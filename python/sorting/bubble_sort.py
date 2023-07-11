arr = [5,4,3,2,1]
flag = 0

for i in range(len(arr)):
    flag = 0
    for j in range(len(arr)-1-i):
        if arr[j] > arr[j+1]:
            arr[j], arr[j+1] = arr[j+1], arr[j]
            flag = 1
    
    if flag == 0:
        break
    
print(arr)
