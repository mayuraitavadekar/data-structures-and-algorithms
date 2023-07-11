arr = [5,4,3,2,1]

for i in range(1, len(arr)):
    j = i-1
    x = arr[i]
    while j > -1 and arr[j] > x:
        arr[j+1] = arr[j]
        j -= 1
        
    arr[j+1] = x
    
print(arr)
