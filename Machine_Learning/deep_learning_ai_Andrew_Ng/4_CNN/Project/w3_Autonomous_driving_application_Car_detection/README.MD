I am working on a self-driving car project for learning. I had build a car detection system.Data is  collected from DRIVE.AI with the help of Andrew NG. 

 <video width="320" height="240" controls>
  <source src="movie.mp4" type="video/mp4">
  <source src="movie.ogg" type="video/ogg">
Your browser does not support the video tag.
</video> 
I have gathered all these images into a folder and have labelled them by drawing bounding boxes around every car you found. Here's an example of what your bounding boxes look like.

<img src

I have 80 classes that I want the object detector to recognize, I have represented the class label cc either as an integer from 1 to 80, or as an 80-dimensional vector (with 80 numbers) one component of which is 1 and the rest of which are 0. The video lectures had used the latter representation; in this notebook, I have used both representations, depending on which is more convenient for a particular step.

In this exercise, I have learned "You Only Look Once" (YOLO) performs object detection, and then apply it to car detection. Because the YOLO model is very computationally expensive to train, I have loaded pre-trained weights for  use. 


Main Points to remember:
    YOLO is a state-of-the-art object detection model that is fast and accurate
    It runs an input image through a CNN which outputs a 19x19x5x85 dimensional volume.
    The encoding can be seen as a grid where each of the 19x19 cells contains information about 5 boxes.
    You filter through all the boxes using non-max suppression. Specifically:
        Score thresholding on the probability of detecting a class to keep only accurate (high probability) boxes
        Intersection over Union (IoU) thresholding to eliminate overlapping boxes
    Because training a YOLO model from randomly initialized weights is non-trivial and requires a large dataset as well as lot of computation, we used previously trained model parameters in this exercise. If you wish, you can also try fine-tuning the YOLO model with your own dataset, though this would be a fairly non-trivial exercise.

