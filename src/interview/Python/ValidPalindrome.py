from collections import deque
from curses.ascii import isalnum
import re


def useList(s: str):
    strs = []
    for char in s:
        if char.isalnum():
            strs.append(char.lower())
    while len(strs) > 1:
        if strs.pop(0) != strs.pop(): # pop(0)의 시간복잡도는 O(n)
            return False
    
    return True

# 데크 자료형을 사용
def useDeque(s: str):
    strs = deque()
    for char in s:
        if char.isalnum():
            strs.append(char.lower())
    
    while len(strs) > 1:
        if strs.popleft() != strs.pop(): # popleft 의 시간복잡도는 O(1)
            return False
    
    return True

# 슬라이싱을 활용한 경우
def useSlicing(s: str):
    s = s.lower()
    s = re.sub('[^a-z0-9]', '', s) # 소문자와 숫자가 아닌 문자들을 ''로 치환한다
    return s == s[::-1]