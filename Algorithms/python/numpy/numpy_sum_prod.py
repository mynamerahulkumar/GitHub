import numpy as np

n,m=map(int,input().split())
arr1=np.array([input().split() for _ in range(n) ],dtype=int)
sum1=np.sum(arr1,axis=0)
print(np.product(sum1,axis=0))
