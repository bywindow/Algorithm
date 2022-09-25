from typing import List

def solution(k: int, dic: List[str], chat: str) -> str:
    answer = ''
    arr_chat = chat.split()

    for c in arr_chat:
        # contain .
        if '.' in c:
            isCorrect = False
            cur = c.split('.')
            for s in dic:
                idx = s.find(cur[0])
                if idx < 0:
                    continue
                for ccur in cur:
                    nidx = s.find(ccur)
                    if nidx - idx >= k:
                        isCorrect = False
                        break
                    isCorrect = True
                if isCorrect == True:
                    for i in range(len(c)):
                        answer += '#'
                    answer += ' '
                    break
            if isCorrect == False:
                answer += c + ' '
            
        else:
            if c in dic:
                for i in range(len(c)):
                    answer += '#'
                answer += ' '
            else:
                answer += c + ' '
    return answer.rstrip()