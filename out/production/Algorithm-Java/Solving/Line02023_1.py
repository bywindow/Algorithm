from typing import List

def spread(a):
    powee = 1
    result = 1
    while result < a:
        result = pow(2, powee)
        powee+=1
    return result


def solution(queries: List[List[int]]) -> int:
    answer = 0
    arr = [0 for _ in range(1001)] # cur length
    mlength = [0 for _ in range(1001)]
    for i in queries:
        a, b = i[0], i[1]
        # 길이가 충분하다면 그냥 추가
        if mlength[a] >= arr[a] + b:
            arr[a] += b
        # 확장해야 된다면
        else:
            answer += arr[a]
            arr[a] += b
            mlength[a] = spread(arr[a])

    return answer