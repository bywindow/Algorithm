def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    
    pivot = arr[len(arr) // 2]
    min_arr, equal_arr, max_arr = [], [], []
    for num in arr:
        if num < pivot:
            min_arr.append(num)
        elif num > pivot:
            max_arr.append(num)
        else:
            equal_arr.append(num)
    return quick_sort(min_arr) + equal_arr + quick_sort(max_arr)