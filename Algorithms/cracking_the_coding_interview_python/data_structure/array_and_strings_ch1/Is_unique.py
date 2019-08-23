#make 128 ARRAY size and put index wise couse ,arr[index]>1 not unique
s = raw_input()
arr = [128] * 0
for i in range(128):
    arr.append(0)
is_unique = True
for c in s:
    a = ord(c)
    arr[a] += 1
    if arr[a] > 1:
        is_unique = False
        break
if is_unique:
    print("Unique string")
else:
    print("Not unique string")

