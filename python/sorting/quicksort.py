arr = [5,3,2,1, 60]

def quicksort(arr, low, high):
    if low < high:
        partition_pos = partition(arr, low, high)
        quicksort(arr, low, partition_pos-1)
        quicksort(arr, partition_pos+1, high)
        
def partition(arr, l, h):
    pivot = h
    i = l
    j = h-1
    
    while i < j:
        while i < h and arr[i] <= arr[pivot]:
            i += 1
        while j > l and arr[j] >= arr[pivot]:
            j -= 1
    
        if i < j:
            arr[i], arr[j] = arr[j], arr[i]
    
    if arr[i] > arr[pivot]:
        arr[i], arr[pivot] = arr[pivot], arr[i]
    
    return i
    
quicksort(arr, 0, len(arr)-1)
print(arr)
        
