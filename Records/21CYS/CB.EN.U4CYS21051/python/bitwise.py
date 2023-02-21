//maximum bitwise XOR of two binary strings after rearrange the strings

t = int(input())

for i in range(t):
    a = list(map(int,input()))
    b = list(map(int,input()))

    la = len(a)
    lb = len(b)

    c = [0 for i in range(50)]
    i = 0

    for x in range(la):
        p = 0 + i
        for y in range(lb):
            if a[x]^b[y] == 1:
                c[x] = 1
                b[y] = 2
                i += 1
                break
            
            elif a[x]^b[y] == 0:
                p+= 1
        if p == la:
            c[x] = 0
    for v in range(i):
        print("1", end="")
    for l in range(la-i):
        print("0", end="")
    print()