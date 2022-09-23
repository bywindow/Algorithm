def rotate(key):
    nkey = []
    for i in range(len(key)):
        cur = []
        for j in range(len(key)):
            cur.append(key[j][i])
        # cur_rev = ''.join(reversed(cur))
        nkey.append(cur[::-1])
    return nkey

def check(nlock, start, n):
    result = True
    for i in range(start, start+n):
        for j in range(start, start+n):
            if nlock[i][j] != 1:
                return False
    return result

def solution(key, lock):
    m, n = len(key), len(lock)
    nlock = [[0] * (m*2 + n) for _ in range(m*2 + n)]
    for i in range(n):
        for j in range(n):
            nlock[i+m][j+m] = lock[i][j]
    
    for r in range(4):
        key = rotate(key)
        # n + m -1 - move
        for i in range(n+m):
            for j in range(n+m):
                # match
                for x in range(m):
                    for y in range(m):
                        nlock[x+i][y+j] += key[x][y]
                if check(nlock, m, n) == True:
                    return True
                for x in range(m):
                    for y in range(m):
                        nlock[x+i][y+j] -= key[x][y]             

    return False

print(solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]], [[1, 1, 1], [1, 1, 0], [1, 0, 1]]))
