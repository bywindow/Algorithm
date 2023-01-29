"""
가중치가 있는 간선을 연결할 때 최소비용 -> 크루스칼 알고리즘
"""
def getParent(parents, node):
    if parents[node] == node:
        return node
    else:
        return getParent(parents, parents[node])

def patchParent(parents, start, end):
    x = getParent(parents, start)
    y = getParent(parents, end)
    parents[x] = parents[y] = min(x, y)

def isCycle(parents, start, end):
    # 부모 노드를 더 작은 숫자의 노드로 바꾼다
    s = getParent(parents, start)
    e = getParent(parents, end)
    if s == e:
        return True
    else:
        return False

def solution(n, costs):
    answer = 0
    costs.sort(key=lambda x:x[2])
    parents = [i for i in range(n)]
    count = 0

    for cur in costs:
        if not isCycle(parents, cur[0], cur[1]):
            answer += cur[2]
            patchParent(parents, cur[0], cur[1])
            count += 1
        if count == n-1:
            break

    return answer