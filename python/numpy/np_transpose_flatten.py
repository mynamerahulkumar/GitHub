import numpy as np

arr_dim = list(map(int, input().split()))
arr_inp = []
for i in range(0, arr_dim[0]):
    a = list(map(int, input().split()))
    arr_inp.append(a)
num_array = np.array(arr_inp)
print(np.transpose(num_array))
print(num_array.flatten())



