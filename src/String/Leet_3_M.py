def lengthOfLongestSubstring(s: str) -> int:
    # add char -> if appear contained char -> make new string : 'dvdf' 경우 틀림
    answer = 0
    output = ''
    for c in s:
        if c in output:
            # make new string
            start = output.index(c)
            output = output[start+1:]
            output += c
        else:
            output += c
            answer = max(answer, len(output))

    return answer

print(lengthOfLongestSubstring(s='dvdf'))