"""
재귀를 이용한 완탐으로 풀어보자
"""

maxDiff = 0
answer = [-1]

def moreSmall(ryan, answer):
    for i in range(len(ryan)-1, 0, -1):
        print(i)
        if answer[i] < ryan[i]:
            return True
        elif answer[i] > ryan[i]:
            return False

def calScore(apeach, ryan):
    global maxDiff, answer
    apeachScore, ryanScore = 0, 0
    for i in range(len(apeach)):
        if apeach[i] < ryan[i]:
            ryanScore += (10-i)
        elif apeach[i] > 0:
            apeachScore += (10-i)
    # 결과값이 max 값과 같다면 작은 점수를 많이 쏜 것을 결정
    curDiff = ryanScore - apeachScore
    if curDiff > 0 and curDiff >= maxDiff:
        if maxDiff == curDiff and not moreSmall(ryan, answer):
            return
        answer = ryan[:]
        maxDiff = curDiff

def recur(apeach, ryan, idx, arrows):
    # end point
    if idx > 10 or arrows == 0:
        # 점수계산으로 넘어가기
        ryan[10] += arrows
        calScore(apeach, ryan)
        ryan[10] -= arrows
        return
    # 해당 점수를 얻는다면
    if apeach[idx] < arrows:
        ryan[idx] = apeach[idx] + 1
        recur(apeach, ryan, idx+1, arrows-ryan[idx])
        ryan[idx] = 0
    # 해당 점수를 얻지 않는다면
    recur(apeach, ryan, idx+1, arrows)

def solution(n, info):
    global answer
    ryan = [0] * 11
    recur(info, ryan, 0, n)
    return answer

print(solution(9, [0,0,1,2,0,1,1,1,1,1,1]))