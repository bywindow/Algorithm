from collections import deque

def bfs(cur):
    p = []
    for r in range(5):
        for c in range(5):
            if cur[r][c] == 'P':
                p.append([r, c])

    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    for s in p:
        dq = deque()
        dq.append(s)
        visited = [[False] * 5 for _ in range(5)]
        distance = [[0] * 5 for _ in range(5)]
        visited[s[0]][s[1]] = True

        while dq:
            y, x = dq.popleft()
            visited[y][x] = True
            for i in range(4):
                nx, ny = x + dx[i], y + dy[i]
                if nx < 0 or nx >= 5 or ny < 0 or ny >= 5:
                    continue
                if visited[ny][nx] == True:
                    continue
                if cur[ny][nx] == 'X':
                    continue
                distance[ny][nx] = distance[y][x] + 1
                if cur[ny][nx] == 'P' and distance[ny][nx] < 3:
                    return 0
                dq.append([ny, nx])

    return 1


def solution(places):
    answer = []
    
    for place in places:
        cur = []
        for row in place:
            cur.append(list(row))
        # print(cur)
        result = bfs(cur)
        answer.append(result)

    return answer

print(solution([["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]))