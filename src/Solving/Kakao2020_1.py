def isBalanced(p) :
    start = 0
    for i in range(len(p)):
        if p[i] == '(':
            start+=1
        elif p[i] == ')':
            start-=1
        if start == 0:
            return i


def solution(p) :
    answer = ''
    if p == '':
        return answer
    i = isBalanced(p)
    # seperate u, v
    u = p[:i+1] # i번째 인덱스의 글자까지 포함하기 때문에 i+1
    v = p[i+1:]

    if u[0] == '(':
        answer = u + solution(v)
    else:
        answer = '('
        answer += solution(v)
        answer += ')'
        nu = ''
        for i in range(1, len(u)-1):
            if u[i] == '(':
                nu += ')'
            else:
                nu += '('
        answer += nu
    
    return answer