import sys
# 단순히 이중for문을 사용하는 접근법 : 시간초과

n = int(sys.stdin.readline())
towns = []
people = 0

for i in range(n):
    x, a = map(int, sys.stdin.readline().strip().split())
    towns.append([x, a])
    people += a
# print(towns)

towns.sort(key=lambda x: x[0])

# 해당 마을의 왼쪽과 오른쪽의 사람 수가 비슷해야한다
# 전체 사람 수를 구하고, 마을을 돌면서 왼쪽 사람수를 뺐을 때 전체의 절반이 넘어가는 순간을 찾는다
left = 0
for i in range(len(towns)):
    left += towns[i][1]
    if left >= people/2:
        answer = towns[i][0]
        break

print(answer)