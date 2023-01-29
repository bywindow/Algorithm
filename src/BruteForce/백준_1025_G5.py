import math
import sys
from tokenize import String


n, m = map(int, sys.stdin.readline().split())
board = []
answer = -1

def isPowered(str):
    n = int(str)
    if math.pow(int(math.sqrt(n)), 2) == n:
        return True
    else:
        return False

def makeNum(i, j, y, x, str):

    cur = str + board[i][j]
    global answer

    if isPowered(cur):
        answer = max(answer, int(cur))
    
    if isPowered(cur[::-1]):
        answer = max(answer, int(cur[::-1]))

    if y == 0 and x == 0:
        return

    if i + y >= n or j + x >= m or j + x < 0:
        return

    makeNum(i+y, j+x, y, x, cur)

for i in range(n):
    board.append(list(sys.stdin.readline().strip()))
# print(board)
for i in range(n):
    for j in range(m):
        for y in range(n):
            for x in range(m):
                makeNum(i, j, y, x, '') # 좌상우하 대각선
                makeNum(i, j, y, -x, '') # 우상좌하 대각선

print(answer)