"""People Counter."""
"""
 Copyright (c) 2018 Intel Corporation.
 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files (the
 "Software"), to deal in the Software without restriction, including
 without limitation the rights to use, copy, modify, merge, publish,
 distribute, sublicense, and/or sell copies of the Software, and to
 permit person to whom the Software is furnished to do so, subject to
 the following conditions:
 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
"""


import os
import sys
import time
import socket
import json
import cv2

import logging as log
import paho.mqtt.client as mqtt

from argparse import ArgumentParser
from inference import Network

# MQTT server environment variables
HOSTNAME = socket.gethostname()
IPADDRESS = socket.gethostbyname(HOSTNAME)
MQTT_HOST = IPADDRESS
MQTT_PORT = 3001
MQTT_KEEPALIVE_INTERVAL = 60


def build_argparser():
    """
    Parsing command line arguments.
    :return: command line arguments
    """
    parser = ArgumentParser()
    parser.add_argument("-m", "--model", required=True, type=str,
                        help="file path  with a trained model.")
    parser.add_argument("-i", "--ip", required=True, type=str,
                        help=" image path or video path file")
    parser.add_argument("-l", "--cpu_extension", required=False, type=str,
                        default=None,
                        help="MKLDNN (CPU)-targeted custom layers."
                             "shared library  absolute path with the"
                             "kernels impl.")
    parser.add_argument("-d", "--device", type=str, default="CPU",
                        help=" target device specification to infer on: "
                             " MYRIAD CPU, GPU or FPGA is acceptable. Sample "
                             " suitable plugin will be checked for device "
                             "specified (CPU by default)")
    parser.add_argument("-pt", "--prob_thresh", type=float, default=0.5,
                        help="Probability thresh for detections filtering"
                        "(0.5 by default)")
    parser.add_argument("-pc", "--perf_counting", type=str, default=False,
                        help="Print performance counters")
    return parser
def getClientCon():
    client = mqtt.Client()
    client.connect(MQTT_HOST, MQTT_PORT, MQTT_KEEPALIVE_INTERVAL)
    return client
def main():
    """
    Load the network and parse the SSD output.
    :return: None
    """
    # Connect to the MQTT server

    client=getClientCon()
    args = build_argparser().parse_args()

    # Flag for the input image
    single_image_mode = False
    last_cnt = 0
    total_cnt = 0
    cur_request_id = 0
    start_time = 0

    # Network Initilization class
    inference_network = Network()
    # Load the network to IE plugin to get shape of input layer
    n, c, h, w = inference_network.load_model(args.model, args.device, 1, 1,
                                          cur_request_id, args.cpu_extension)[1]



    # input image detection
    if args.ip.endswith('.jpg') or args.ip.endswith('.bmp') :
        single_image_mode = True
        ip_stream = args.ip
    #  live feed detection
    elif args.ip == 'CAM':
        ip_stream = 0
    #video file detection
    else:
        ip_stream = args.ip
    cap = cv2.VideoCapture(ip_stream)

    if ip_stream:
        cap.open(args.ip)

    if not cap.isOpened():
        log.error("There is some error in opening video file")
    global initial_w, initial_h, prob_thresh
    prob_thresh = args.prob_thresh
    initial_w = cap.get(3)
    initial_h = cap.get(4)
    while cap.isOpened():
        flag, frame = cap.read()
        if not flag:
            break
        key_pressed = cv2.waitKey(60)
        # Starting asynchronous inference process
        img = cv2.resize(frame, (w, h))
        # HWC to CHW chaging data layout
        img = img.transpose((2, 0, 1))
        img = img.reshape((n, c, h, w))
        # Starting async inference for specified requestId.
        inf_start = time.time()
        inference_network.execute_network(cur_request_id, img)
        #waiting for the outcome
        if inference_network.wait(cur_request_id) == 0:
            det_time = time.time() - inf_start
            # Network o/p layer result
            result = inference_network.get_op(cur_request_id)
            if args.perf_counting:
                perf_counting = inference_network.counting_performance(cur_request_id)
                counting_performance(perf_counting)

            frame, current_count = ssd_out(frame, result)
            inf_time_message = "Inference time=: {:.4f}ms"\
                               .format(det_time * 1000)
            cv2.putText(frame, inf_time_message, (20, 20),
                        cv2.FONT_HERSHEY_COMPLEX, 0.5, (0, 255, 0), 1)


            # detection of new person in video
            if current_count > last_cnt:
                start_time = time.time()
                total_cnt = total_cnt + current_count - last_cnt
                client.publish("person", json.dumps({"total": total_cnt}))
            if total_cnt >= 1:
                cv2.putText(frame, 'At least one person present', (35, 35), cv2.FONT_HERSHEY_COMPLEX, 0.5, (0, 0, 255), 1)
            # Person duration in the video is calculated
            if current_count < last_cnt:
                duration = int(time.time() - start_time)
                print('duration-----',duration)
                # sending message to MQTT server
                # duration <8 then it could be due to fluctuation so ignore the fluctuation
                if duration>8:
                    client.publish("person/duration",
                             json.dumps({"duration": duration}))
            client.publish("person", json.dumps({"count": current_count}))
            last_cnt = current_count

            if key_pressed == 27:
                break

        # Sendings frame to the ffmpeg server
        sys.stdout.buffer.write(frame)
        sys.stdout.flush()

        if single_image_mode:
            cv2.imwrite('output_image.jpg', frame)
    cap.release()
    cv2.destroyAllWindows()
    client.disconnect()
    inference_network.clean()
def ssd_out(frame, result):
    """
    Parse SSD output.
   frame: frame from camera/video
   result: list contains the data to parse ssd
    return: person count and frame
    """
    current_count = 0
    for obj in result[0][0]:
        # Draw bounding box for object when it's probability is more than
        #  the specified threshold
        if obj[2] > prob_thresh:
            xmin = int(obj[3] * initial_w)
            ymin = int(obj[4] * initial_h)
            xmax = int(obj[5] * initial_w)
            ymax = int(obj[6] * initial_h)
            cv2.rectangle(frame, (xmin, ymin), (xmax, ymax), (0, 55, 255), 1)
            current_count = current_count + 1
    return frame, current_count
def counting_performance(perf_counting):
    """
    print information about layers of the model.
    """
    print("{:<70} {:<15} {:<15} {:<15} {:<10}".format('name', 'layer_type',
                                                      'exec_type', 'status',
                                                      'real_time, us'))
    for layer, stats in perf_counting.items():
        print("{:<70} {:<15} {:<15} {:<15} {:<10}".format(layer,
                                                          stats['layer_type'],
                                                          stats['exec_type'],
                                                          stats['status'],
                                                          stats['real_time']))




if __name__ == '__main__':
    main()
    exit(0)