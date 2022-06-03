class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        answer = strs[0]
        # [1]번째 string부터 answer과 비교
        for s in range(1, len(strs)):
            curStr = strs[s]
            # answer의 길이까지만 비교하면 됨
            while curStr[:len(answer)] != answer:
            # 같지 않으니까 answer의 길이를 1씩 줄여나간다
                answer = answer[:len(answer)-1]
                if len(answer) == 0:
                    return ""
        return answer
