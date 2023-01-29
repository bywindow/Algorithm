"""
bfs로 방문이력 검사하면서 인접 노드를 체크한다.
"""

def solution(n, computers):
    answer = 0
    visited = [0 for _ in range(n)]

    for i in range(n):
        if visited[i] == 1:
            continue
        visited[i] = 1
        q = [i]
        while q:
            cur = q.pop(0)
            for j in range(n):
                if computers[cur][j] and visited[j] == 0:
                    q.append(j)
                    visited[j] = 1
        answer += 1

            
    return answer

print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))