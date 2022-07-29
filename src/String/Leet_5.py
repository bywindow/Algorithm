def longestPalindrome(s: str):
    def expand(left: int, right: int):
        while left >= 0 and right <= len(s) and s[left] == s[right-1]:
            left -= 1
            right += 1
        return s[left+1:right-1]
    # 예외사항
    if len(s) < 2 or s == s[::-1]:
        return s
    # 초기 길이가 2,3인 포인터 두개를 만들고 문자열의 우측으로 확장해나간다.
    answer = ' '
    # 포인터 전체의 이동
    for i in range(len(s)):
        answer = max(answer, expand(i, i+1), expand(i, i+2), key=len)
    return answer

print(longestPalindrome("babad"))