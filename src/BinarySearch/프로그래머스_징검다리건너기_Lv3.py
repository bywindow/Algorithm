"""
배열에서 최소값을 찾아 모든 원소에서 빼주고 건널 수 있는지 검사하는 과정 반복 -> 시간초과
최댓값이 정해져 있으므로 이분탐색으로 풀어보자
"""

def solution(stones, k):
    
    left, right = 1, 200000000

    while left <= right:
        mid = (left + right) // 2
        cnt = 0
        for i in range(len(stones)):
            if stones[i] - mid <= 0:
                cnt += 1
                if cnt >= k:
                    # 건널 수 있는 사람이 무한대로 가정
                    break
            else:
                cnt = 0
        if cnt >= k:
            right = mid - 1
        else:
            left = mid + 1
        
    answer = left

    return answer

print(solution([2, 4, 5, 3, 2, 1, 4, 2, 5, 1], 3))