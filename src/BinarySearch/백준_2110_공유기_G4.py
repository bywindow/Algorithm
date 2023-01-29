"""
가장 인접한 두 공유기 사이의 거리를 최대로 한다
"""
import sys


n, c = map(int, sys.stdin.readline().strip().split())
houses = [0] * n
# print(houses)
for i in range(n):
    houses[i] = int(sys.stdin.readline())

houses = sorted(houses)

# 공유기 사이의 최소 거리가 가장 먼 경우는 일정한 간격으로 배치되었을 떄
# 초기 거리를 반으로 잡고 이분탐색
minLen = 1
maxLen = houses[n-1] - houses[0]
answer = 0

# 무조건 양 끝에 공유기 하나씩 배치
if c == 2:
    print(maxLen)
    sys.exit(0)

while minLen <= maxLen :
    mid = (maxLen + minLen) // 2
    cnt = 2
    prevHouse = houses[0]
    for i in range(1, n-1):
        left, right = houses[i] - prevHouse, houses[n-1] - houses[i]
        cur = min(left, right)
        if cur >= mid:
            cnt+=1
            prevHouse = houses[i]
        
    if cnt >= c:
        answer = max(answer, mid)
        minLen = mid +1
        continue

    if cnt < c:
        maxLen = mid - 1

print(answer)