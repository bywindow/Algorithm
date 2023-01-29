import math
answer = math.inf

def solution(begin, target, words):
    
    
    visited = [0] * len(words)

    def find_next(cur, next):
        cnt = 0
        for i in range(len(next)):
            if cur[i] != next[i]:
                cnt+=1
        if cnt == 1:
            return True
        else:
            return False

    def dfs(cur, count):

        global answer

        if cur == target:
            answer = min(answer, count)
            return
        if count > answer:
            return
        
        for i in range(len(words)):
            if visited[i] == 0 and find_next(cur, words[i]):
                visited[i] = 1
                dfs(words[i], count+1)
                visited[i] = 0
        
    dfs(begin, 0)

    return 0 if answer == math.inf else answer

print(solution('hit', 'cog', ["hot", "dot", "dog", "lot", "log"]))