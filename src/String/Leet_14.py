class Solution:
  def longestCommonPrefix(self, strs: List[str]) -> str:
    answer = strs[0]
    for s in strs:
      if(answer != s):
        cnt = 0
        for i in range(len(answer)):
          if(answer[i] == s[i]):
            cnt = i
          else : 
            break
        answer = answer[:cnt]
    return answer
