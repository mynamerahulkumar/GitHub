import numpy as np

#take tuples as input,and pass tuple to numpy ,it will print zeros and one
t=tuple(map(int,input().split()))
zero_matrix=np.zeros(t,dtype=np.int)
one_matrix=np.ones(t,dtype=int)
print(zero_matrix)
print(one_matrix)


