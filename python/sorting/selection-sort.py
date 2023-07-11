arr = [5,4,3,2,1]

for i in range(len(arr)):
    k = i
    for j in range(i, len(arr)):
        if arr[j] < arr[i]:
            k = j
            
    # swap
    arr[i], arr[k] = arr[k], arr[i]
    
print(arr)


