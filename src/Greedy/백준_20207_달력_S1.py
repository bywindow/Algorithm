import sys

n = int(sys.stdin.readline())
calender = [0 for _ in range(366)]

for i in range(n):
    s, e = map(int, sys.stdin.readline().split())
    for j in range(s, e+1):
        calender[j] += 1 # depth를 기록해 나간다

# 코팅지 넓이 계산
height = 0
width = 0
size = 0
for i in range(len(calender)):
    if calender[i] != 0:
        height = max(height, calender[i])
        width += 1
    else:
        size += width * height
        width = 0
        height = 0
# 365일에 일정이 있는 경우
size += width * height

print(size)