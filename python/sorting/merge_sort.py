arr = [5,4,3,2,1]

def merge(arr, low, mid, high):
    
    # take temp_arr with large size
    temp_arr = [0 for i in range(len(arr))]
    k = low
    
    i = low
    j = mid + 1
    
    while i <= mid and j <= high:
        if arr[i] < arr[j]:
            temp_arr[k] = arr[i]
            i += 1
            k += 1
        else:
            temp_arr[k] = arr[j]
            j += 1
            k += 1
    
    # if anything is remaining in i
    while i <= mid:
        temp_arr[k] = arr[i]
        i += 1
        k += 1
    
    # or if anything is remaining in j
    while j <= high:
        temp_arr[k] = arr[j]
        j += 1
        k += 1
    
        
    # now put result from temp_arr to arr
    for i in range(low, high+1):
        arr[i] = temp_arr[i]
    
def merge_sort(arr, low, high):
    if low < high:
        mid = int((high+low)/2)
        merge_sort(arr, low, mid)
        merge_sort(arr, mid+1, high)
        merge(arr, low, mid, high)
    
print("array before sorting: ")
print(arr)
merge_sort(arr, 0, len(arr)-1)
print("array after sorting: ")
print(arr)

