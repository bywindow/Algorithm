import sys


n, h, d = map(int, sys.stdin.readline().split())
land = []
startX, startY = 0, 0
for i in range(n):
    cur = sys.stdin.readline().strip()
    land.append(list(cur))
    if 'S' in cur:
        # print(cur.index('S'), i)
        startY, startX = i, cur.index('S')
moveX = [0, 0, -1, 1] # 상하좌우
moveY = [-1, 1, 0, 0]
# 안전지대로 이동할 때의 최소이동횟수를 구한다
# 이동하기 전 우산을 쓰고 있는지 체크하고 먼저 우산체력부터 -1

visited = [[0] * n for _ in range(n)] # 방문체크
q = [[startY, startX, h, 0, 0]] # 각 격자에서의 상태값을 한번에 체크
visited[startY][startX] = h

while q:
    r, c, curh, curu, cnt = q.pop(0)
    # print(r, c)
    # 먼저 큐에 넣은 뒤에 판단하지 말고, 판단한 뒤 큐에 넣자
    for i in range(4):
        nr = r + moveY[i]
        nc = c + moveX[i]
        if nr < 0 or nr >= n or nc < 0 or nc >= n:
            continue
        if land[nr][nc] == 'E':
            print(cnt+1)
            sys.exit(0)
        nh, nu = curh, curu
        # 우산이 있다면
        if land[nr][nc] == 'U':
            nu = d
        # 비가 오는 곳이라면
        if nu == 0:
            nh -= 1
        else:
            nu -= 1
        if nh == 0:
            continue

        if visited[nr][nc] < nh:
            # 더 많은 체력으로 갈 수 있다면 추가
            visited[nr][nc] = nh
            q.append([nr, nc, nh, nu, cnt+1])
print(-1)