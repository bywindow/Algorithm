from typing import List

def solution(n: int, m: int, fires: List[List[int]], ices: List[List[int]]) -> List[List[int]]:
    answer = [[0]*n for _ in range(n)]

    for cm in range(1, m+1):
        for x, y in fires:
            up, down, left, right = max(0,y-1-cm), min(n,y-1+cm), max(0,x-1-cm), min(n,x-1+cm)
            for i in range(up, down):
                for j in range(left, right):
                    answer[i][j] += 1

        for x, y in ices:
            up, down, left, right = max(0,y-1-cm), min(n,y-1+cm), max(0,x-1-cm), min(n,x-1+cm)
            for i in range(up, down):
                for j in range(left, right):
                    answer[i][j] -= 1
        print(answer)
    return answer

solution(3, 2, [[1,1]], [[3,3]])