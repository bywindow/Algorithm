"""
k 그룹으로 나눈다 -> k-1 개의 경계를 만들어야 한다.
가장 차이가 큰 숫자 사이에 경계를 만들면 최대이득이다.
=> 그 차이만큼 최종값에서 사라지고 0이 된다
"""


import sys


n, k = map(int, sys.stdin.readline().strip().split())
student = list(map(int, sys.stdin.readline().strip().split()))
# print(student)
answer = 0

if n == k:
    print(answer)
    sys.exit(0)

# 초기값 설정
answer = student[len(student)-1] - student[0]
diff = []
for i in range(len(student)-1):
    diff.append(student[i+1]-student[i])

diff = sorted(diff)
diff.reverse()

for i in diff:
    if k == 1:
        break
    answer -= i
    k -= 1

print(answer)