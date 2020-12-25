Character level language model - Dinosaurus Island

Welcome to Dinosaurus Island! 65 million years ago, dinosaurs existed, and in this assignment they are back. You are in charge of a special task. Leading biology researchers are creating new breeds of dinosaurs and bringing them to life on earth, and your job is to give names to these dinosaurs. If a dinosaur does not like its name, it might go berserk, so choose wisely! 
<img src="images/dianasour.png">
Luckily you have learned some deep learning and you will use it to save the day. Your assistant has collected a list of all the dinosaur names they could find, and compiled them into this dataset. (Feel free to take a look by clicking the previous link.) To create new dinosaur names, you will build a character level language model to generate new names. Your algorithm will learn the different name patterns, and randomly generate new names. Hopefully this algorithm will keep you and your team safe from the dinosaurs' wrath!

By completing this assignment you will learn:

    How to store text data for processing using an RNN
    How to synthesize data, by sampling predictions at each time step and passing it to the next RNN-cell unit
    How to build a character-level text generation recurrent neural network
    Why clipping the gradients is important

We will begin by loading in some functions that we have provided for you in rnn_utils. Specifically, you have access to functions such as rnn_forward and rnn_backward which are equivalent to those you've implemented in the previous assignment. 

 Expected Output

j =  0 idx =  0
single_example = turiasaurus
single_example_chars ['t', 'u', 'r', 'i', 'a', 's', 'a', 'u', 'r', 'u', 's']
single_example_ix [20, 21, 18, 9, 1, 19, 1, 21, 18, 21, 19]
 X =  [None, 20, 21, 18, 9, 1, 19, 1, 21, 18, 21, 19] 
 Y =        [20, 21, 18, 9, 1, 19, 1, 21, 18, 21, 19, 0] 

Iteration: 0, Loss: 23.087336

Nkzxwtdmfqoeyhsqwasjkjvu
Kneb
Kzxwtdmfqoeyhsqwasjkjvu
Neb
Zxwtdmfqoeyhsqwasjkjvu
Eb
Xwtdmfqoeyhsqwasjkjvu


j =  1535 idx =  1535
j =  1536 idx =  0
Iteration: 2000, Loss: 27.884160

...

Iteration: 34000, Loss: 22.447230

Onyxipaledisons
Kiabaeropa
Lussiamang
Pacaeptabalsaurus
Xosalong
Eiacoteg
Troia



This implementation of  key components of a Recurrent Neural Network in numpy.

Recurrent Neural Networks (RNN) are very effective for Natural Language Processing and other sequence tasks because they have "memory". They can read inputs x⟨t⟩x⟨t⟩ (such as words) one at a time, and remember some information/context through the hidden layer activations that get passed from one time-step to the next. This allows a unidirectional RNN to take information from the past to process later inputs. A bidirectional RNN can take context from both the past and the future. 
1 - Forward propagation for the basic Recurrent Neural Network

Later this week, you will generate music using an RNN. The basic RNN that you will implement has the structure below. In this example, Tx=TyTx=Ty.


A recurrent neural network can be seen as the repeated use of a single cell. You are first going to implement the computations for a single time-step. The following figure describes the operations for a single time-step of an RNN cell. 

<img src="w1_RNN_LSTM/images/rnn_step_forward_figure2_v3a.png" style="width:700px;height:300px;">
 Figure 2: Basic RNN cell. Takes as input x⟨t⟩x⟨t⟩ (current input) and a⟨t−1⟩a⟨t−1⟩ (previous hidden state containing information from the past), and outputs a⟨t⟩a⟨t⟩ which is given to the next RNN cell and also used to predict ŷ ⟨t⟩y^⟨t⟩
rnn cell versus rnn_cell_forward

    Note that an RNN cell outputs the hidden state a⟨t⟩a⟨t⟩.
        The rnn cell is shown in the figure as the inner box which has solid lines.
    The function that we will implement, rnn_cell_forward, also calculates the prediction ŷ ⟨t⟩y^⟨t⟩
        The rnn_cell_forward is shown in the figure as the outer box that has dashed lines.

<img src="w1_RNN_LSTM/images/rnn_forward_sequence_figure3_v3a.png" style="width:800px;height:180px;">
Figure 3: Basic RNN. The input sequence x=(x⟨1⟩,x⟨2⟩,...,x⟨Tx⟩)x=(x⟨1⟩,x⟨2⟩,...,x⟨Tx⟩) is carried over TxTx time steps. The network outputs y=(y⟨1⟩,y⟨2⟩,...,y⟨Tx⟩)y=(y⟨1⟩,y⟨2⟩,...,y⟨Tx⟩).

2 - Long Short-Term Memory (LSTM) network

The following figure shows the operations of an LSTM-cell.
<img src="w1_RNN_LSTM/images/LSTM_figure4_v3a.png" style="width:500;height:400px;">


LSTM-cell. This tracks and updates a "cell state" or memory variable c⟨t⟩c⟨t⟩ at every time-step, which can be different from a⟨t⟩a⟨t⟩.
Note, the softmax∗softmax∗ includes a dense layer and softmax

Similar to the RNN example above, I have implemented the LSTM cell for a single time-step. Then you can iteratively call it from inside a "for-loop" to have it process an input with TxTx time-steps.

Forward pass for LSTM
<img src="w1_RNN_LSTM/images/LSTM_rnn.png" style="width:500;height:300px;">

Now that you have implemented one step of an LSTM, I can now iterate this over this using a for-loop to process a sequence of TxTx inputs.

