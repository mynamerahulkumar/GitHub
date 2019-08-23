s=raw_input()
l=int(input())
print s
s=s[0:l]
str=""
for c in s:
    if c==" ":
        str=str+"%20"
    else:
        str=str+c
print(str)