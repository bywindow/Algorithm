def isCorrect(cur): 
    # 설치하거나 삭제한 후에 가능한지 파악
    for x, y, t in cur:
        # 보
        if t == 1:
            # 한쪽 끝에 벽이 있어야한다.
            # 양쪽 중 어느 곳에도 기둥이 없다면, 두 곳 모두 보에 연결되어 있어야한다.
            if [x, y-1, 0] in cur or [x+1, y-1,0] in cur or ([x-1, y, 1] in cur and [x+1, y, 1] in cur):
                continue
            return False
        # 기둥
        elif t == 0:
            if y == 0 or [x-1, y, 1] in cur or [x, y-1, 0] in cur or [x, y, 1] in cur:
                continue
            return False
    return True

def solution(n, build_frame):
    answer = []
    # 하나씩 배치하면서 추가
    map = [[0] * n for _ in range(n)]
    for i in range(len(build_frame)):
        x, y, t, flag = build_frame[i][0], build_frame[i][1], build_frame[i][2], build_frame[i][3]
        if flag == 1:
            # 설치
            answer.append([x, y, t])
            if not isCorrect(answer): 
                answer.remove([x, y, t])
        elif flag == 0:
            answer.remove([x, y, t])
            if not isCorrect(answer):
                answer.append([x, y, t])
    return sorted(answer)

print(solution(5, [[0,0,0,1],[2,0,0,1],[4,0,0,1],[0,1,1,1],[1,1,1,1],[2,1,1,1],[3,1,1,1],[2,0,0,0],[1,1,1,0],[2,2,0,1]]))