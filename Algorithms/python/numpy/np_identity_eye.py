import numpy as np

a,b=map(int,input().split())
ide_mat=np.eye(a,b,k=0)
print(str(ide_mat).replace('1',' 1').replace('0',' 0'))




