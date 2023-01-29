# by recur
from collections import Counter


def removeDuplicateLetters(s: str):
    for char in sorted(set(s)):
        suffix = s[s.index(char):]
        if set(s) == set(suffix):
            return char + removeDuplicateLetters(suffix.replace(char, ''))
    return ''

def byStack(s: str):
    counter, seen, stack = Counter(s), set(), []
    for char in s:
        counter[char] -= 1
        if char in seen:
            #이미 처리된 문자는 스킵
            continue
        while stack and char < stack[-1] and counter[stack[-1]] > 0:
            seen.remove(stack.pop())
        stack.append(char)
        seen.add(char)
        
    return ''.join(stack)