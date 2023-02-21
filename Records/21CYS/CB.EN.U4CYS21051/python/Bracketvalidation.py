b = input()

chars = list(b)
chars1 = chars

length = len(chars)
x = int((length+1)/2)

a = 0

for i in range(0,length):
    if chars[i] == '[':
        for j in range(0,length):
            if chars[j] == ']':
                chars[i] = 0
                chars[j] = 0
                a += 1
                break
    elif chars[i] == '{':
        for j in range(0,length):
            if chars[j] == '}':
                chars[i] = 0
                chars[j] = 0
                a += 1
                break
    elif chars[i] == '(':
        for j in range(0,length):
            if chars[j] == ')':
                chars[i] = 0
                chars[j] = 0
                a += 1
                break
            
if a == x:
    print("VALID")
else:
    print("INVALID")
    
