class Solution:
  def romanToInt(self, s: str) -> int:
    # dictionary를 사용하자
    symbol = { 'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000 }
    i = 1000
    answer = 0
    for c in s:
      cur = symbol[c]
      isSub = i < cur
      if(isSub) : answer += (cur - 2 * i)
      else : answer += cur
      i = cur
    return answer