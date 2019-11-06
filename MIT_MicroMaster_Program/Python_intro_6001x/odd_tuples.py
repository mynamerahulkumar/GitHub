def oddTuples(aTup):
    '''
    aTup: a tuple

    returns: tuple, every other element of aTup. 
    '''
    # Your Code Here
    out=()
    for s in aTup:
        if len(s)%2 !=0:
            print(len(s))
            out=out+ (s,)
    return  out

s=('I', 'am', 'a', 'test', 'tuple')

res=oddTuples(s)
print(res)
