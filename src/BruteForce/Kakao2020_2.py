def solution(s):
    answer, total = len(s), len(s)
    
    for i in range(1, total):
        ansStr = ""
        cur = s[0:i]
        cnt = 1 # 0부터 넣으면 안된다. 만약 10번 반복되었다면 숫자 9가 되고, 틀린 케이스가 존재한다.
        for j in range(i, total, i):
            if cur == s[j:j+i]:
                cnt+=2
            else:
                ansStr += str(cnt) + cur if cnt >= 2 else cur
                cur = s[j:j+i]
                cnt = 1
        # 마지막 블럭은 for문 안에서 탐색되지 않는다.
        ansStr += str(cnt) + cur if cnt >= 2 else cur
        answer = min(len(ansStr), answer)

    return answer

print(solution("abcabcdede"))