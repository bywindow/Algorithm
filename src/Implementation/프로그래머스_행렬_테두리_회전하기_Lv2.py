def solution(rows, columns, queries):
    answer = []
    mat = [[(j-1) * columns + i for i in range(1, columns+1)] for j in range(1, rows+1)]
    # print(mat)
    moveX = [0, 1, 0, -1]
    moveY = [1, 0, -1, 0]

    for tr, tc, br, bc in queries:
        # print(tl, tr, bl, br)
        curR, curC = tr-1, tc-1
        temp = mat[curR][curC]
        result = temp
        for i in range(4):
            while (curR + moveY[i]) in range(tr-1, br) and (curC + moveX[i]) in range(tc-1, bc):
                nr, nc = curR + moveY[i], curC + moveX[i]
                mat[curR][curC] = mat[nr][nc]
                result = min(result, mat[curR][curC])
                curR, curC = nr, nc
        mat[tr-1][tc] = temp
        # print(mat)
        answer.append(result)

    return answer

rows = 6
columns = 6
queries = [[2,2,5,4],[3,3,6,6],[5,1,6,3]]
print(solution(rows, columns, queries))