import sys
n, x = map(int, sys.stdin.readline().split(' '))
# print(n,x)
arr = list(map(int, sys.stdin.readline().split(' ')))
# print(arr)
end = x
res = 0
for i in range(end):
    res += arr[i]
maxRes = res
cnt = 1
for i in range(end, n, 1):
    start = i - x
    res = res + arr[i] - arr[start]
    if res > maxRes:
        maxRes = res
        cnt = 1
    elif res == maxRes:
        cnt += 1

if maxRes == 0:
    print('SAD')
else:
    print(maxRes)
    print(cnt)