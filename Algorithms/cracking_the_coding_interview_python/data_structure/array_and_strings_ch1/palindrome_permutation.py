s=raw_input()
arr=[128]*0
for i in range(128):
    arr.append(0)
length=0
for c in s:
    if c!=" ":
        a=ord(c)
        arr[c]+=1
        length+=1
is_palind=True
if length%2==0:
    for i in range(128):
        if arr[i]%2!=0:
            is_palind=False
            break
else:
    odd_cnt=0
    for i in range(128):
        if arr[i]%2!=0:
            odd_cnt+=1
            if odd_cnt>1:
                is_palind=False
if is_palind:
    print "Yes palindrome"
else:
    print "No palindrome"


