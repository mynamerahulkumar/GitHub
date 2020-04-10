"""
 Copyright (c) 2018 Intel Corporation.
 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files (the
 "Software"), to deal in the Software without restriction, including
 without limitation the rights to use, copy, modify, merge, publish,
 distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to
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
import logging as log
from openvino.inference_engine import IENetwork, IEPlugin





class Network:
    """
   inference plugin  Loading and configuring  for the specified target device
    and performs  asynchronous synchronous and modes for the specified inference requests.
    """

    def __init__(self):
        self.network = None
        self.plugin = None
        self.ip_blob = None
        self.out_blob = None
        self.net_plugin = None
        self.inference_req_handle = None

    def get_op(self, request_id, output=None):
        """
        o/p layer result list

        """
        if output:
            res = self.inference_req_handle.outputs[output]
        else:
            res = self.net_plugin.requests[request_id].outputs[self.out_blob]
        return res

    def get_ip_shape(self):
        """
       I/p layer shape
            """
        return self.network.inputs[self.ip_blob].shape

    def clean(self):
        """
        Deleting instances
        """
        del self.net_plugin
        del self.plugin
        del self.network

    def execute_network(self, request_id, frame):
        """
       starting async inference for specific request id

        """
        self.inference_req_handle = self.net_plugin.start_async(
            request_id=request_id, inputs={self.ip_blob: frame})
        return self.net_plugin

    def wait(self, request_id):
        """
       waiting for the outcome

        """
        wait_process = self.net_plugin.requests[request_id].wait(-1)
        return wait_process

    def counting_performance(self, request_id):
        """
       find out most consuming layer and the performance of layer
        """
        perf_count = self.net_plugin.requests[request_id].get_perf_counts()
        return perf_count

    def load_model(self, model, device, ip_size, op_size, num_req, CPU_extension=None, plugin=None):
        """
         Loads a network and an image to the Inference Engine plugin ,model-xml file for pre trained model,extension for CPU device,
         ip-size:Input layers count,op-size:ouput layers count,num_req:inference request value index,plugin for specified value
        : model: .xml file of pre trained model

        """

        model_xml = model
        model_bin = os.path.splitext(model_xml)[0] + ".bin"
        #specified device plugin intilization
        # specified libarary load
        if not plugin:
            log.info(" plugin Initialization for {} device...".format(device))
            self.plugin = IEPlugin(device=device)
        else:
            self.plugin = plugin

        if CPU_extension and 'CPU' in device:
            self.plugin.add_cpu_extension(CPU_extension)

        #  Inference reading
        log.info("Reading Inference...")
        self.network = IENetwork(model=model_xml, weights=model_bin)
        log.info("Load Inference to the plugin...")

        if self.plugin.device == "CPU":
            supported_layers = self.plugin.get_supported_layers(self.network)
            not_supported_layers = \
                [l for l in self.network.layers.keys() if l not in supported_layers]
            if len(not_supported_layers) != 0:
                log.error("Layers which are not supported by plugin from specified device "
                          " {}:\n {}".
                          format(self.plugin.device,
                                 ', '.join(not_supported_layers)))
                log.error("CPU extensions library path was not specified"
                          " in command line parameters using -l "
                          "or --CPU_extension command line argument")
                sys.exit(1)

        if num_req == 0:
            # Loads network read from IR to the plugin
            self.net_plugin = self.plugin.load(network=self.network)
        else:
            self.net_plugin = self.plugin.load(network=self.network, num_requests=num_req)

        self.ip_blob = next(iter(self.network.inputs))
        self.out_blob = next(iter(self.network.outputs))

        return self.plugin, self.get_ip_shape()


