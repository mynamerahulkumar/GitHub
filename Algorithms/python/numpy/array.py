import numpy
def arrays(arr):
    # complete this function
    # use numpy.array
    rever_arr = numpy.flipud(arr)
    return numpy.array(rever_arr, float)


arr = input().strip().split(' ')
result = arrays(arr)
print(result)
