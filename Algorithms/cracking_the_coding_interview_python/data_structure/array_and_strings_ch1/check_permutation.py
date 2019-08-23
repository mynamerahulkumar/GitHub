#sort two string and compare the string
s1=raw_input()
s2=raw_input()
s1=sorted(s1)
s1="".join(sorted(s1))
s2="".join(sorted(s2))
if s1==s2:
    print("permutation string")
else:
    print ("Not permutation string")
