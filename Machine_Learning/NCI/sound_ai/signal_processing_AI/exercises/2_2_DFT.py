import numpy as np
import  matplotlib.pyplot as plt

#Complex discrete fourier transform
N=64 #size
k0=7# freq
x=np.exp(1j*2*np.pi*k0/N*np.arange(N)) #time
X=np.array([])
for k in range(N):
    s=np.exp(1j*2*np.pi*k/N*np.arange(N))
    X=np.append(X,sum(x*np.conjugate(s)))
plt.plot(np.arange(N),abs(X))
plt.axis([0,N-1,0,N])
plt.show() #at 7 pick will be high


#Real  signal

N=64 #size
k0=7# freq
x=np.cos(2*np.pi*k0/N*np.arange(N)) #time
X=np.array([])
for k in range(N):
    s=np.exp(1j*2*np.pi*k/N*np.arange(N))
    X=np.append(X,sum(x*np.conjugate(s)))
plt.plot(np.arange(N),abs(X))
plt.axis([0,N-1,0,N])
plt.show() #at 7 pick will be high

# Inverse discrete fourier transform
N=64 #size
k0=7.5# freq
x=np.cos(2*np.pi*k0/N*np.arange(N)) #time
X=np.array([])
nv=np.arange(-N/2,N/2)
kv=np.arange(-N/2,N/2)
for k in kv:
    s=np.exp(1j*2*np.pi*k/N*nv)
    X=np.append(X,sum(x*np.conjugate(s)))
Y=np.array([])
for n in nv:
    s=np.exp(1j*2*np.pi*n/N*kv)
    Y=np.append(Y,1.0/N*sum(X*s))
plt.plot(kv,Y)
plt.axis([-N/2,N/2-1,-1,1])
plt.show()




