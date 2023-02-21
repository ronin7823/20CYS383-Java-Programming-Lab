//print the sequence where: even = n/2, odd = 3*n+1 and check which seq have highest length


n = int(input())
opt = int(input())
i = int(n) 

if opt == 1:
    print(i, end=" ")
    while(i>1):
        if i%2 == 0:
            i = int(i/2)
            print(i, end=" ")
        else:
            i = int((3*i)+1)
            print(i, end=" ")
if opt == 2:
    arr = []
    for i in range(1,n+1):
        length = 1
        while(i>1):
            if i%2 == 0:
                i = int(i/2)
                length += 1
            else:
                i = int((3*i)+1)
                length += 1
        arr.append(length)
    index = arr.index(max(arr))
    print(index+1)

        
    