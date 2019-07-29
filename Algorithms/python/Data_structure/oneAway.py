#add or delete check one mismatch only
#replace check only one replace required
s1 = input()
s2 = input()


def addOrDelete(s1, s2):
    isFound=False
    j=0
    for i in range(0,len(s2)):
        if(s1[i]!=s2[j]):
            if(isFound):
                return  False
            isFound=True
        else:
            j+=1
    return True

def oneReplace(s1,s2):
    isFound=False
    for i in range(0,len(s1)):
        if(s1[i]!=s2[i]):
            if isFound:
                return False
            isFound=True
    return True

if (len(s1) - 1) == len(s2):
    if(addOrDelete(s1, s2)):
        print("one away true")
    else:
        print("one away False")
elif (len(s2) - 1) == len(s1):
   if addOrDelete(s2, s1):
       print("one away true")
   else:
       print("one away False")
elif len(s1)==len(s2):
    if oneReplace(s1,s2):
        print("one away True")
    else:
        print("onw away False")
else:
    print("one away False")
