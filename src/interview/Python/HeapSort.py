def heapify(li, index, n):
    l = index * 2 + 1
    r = index * 2 + 2
    s_idx = index
    if l <= n and li[s_idx] > li[l]:
        s_idx = l
    if r <= n and li[s_idx] > li[r]:
        s_idx = r
    if s_idx != index:
        li[index], li[s_idx] = li[s_idx], li[index]
        return heapify(li, s_idx, n)
def heap_sort(arr):
    n = len(arr)

    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, i, n)
    
    for i in range(n-1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        heapify(arr, 0, i)
    return arr