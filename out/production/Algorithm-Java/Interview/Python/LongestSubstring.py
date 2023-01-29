def lengthOfSubstring(s: str):
    used = {}
    maxLen, start = 0, 0
    for index, char in enumerate(s):
        if char in used and start <= used[char]:
            start = used[char] + 1
        else:
            maxLen = max(maxLen, index - start + 1)
        used[char] = index
    return maxLen