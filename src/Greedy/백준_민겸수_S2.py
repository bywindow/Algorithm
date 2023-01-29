"""
문자열의 길이 <= 3000 -> 숫자로 대수비교하면 안된다
최댓값 : M과 K를 하나의 그룹으로 10진수를 만들 때
최솟값 : M과 K를 나눌 때
"""

import sys

str = sys.stdin.readline().strip()

max, min = "", ""
cntM = 0

for s in str:
    # print(s)
    if s == 'M':
        cntM+=1
        continue
    # K가 나왔을 때
    max += '5' + '0' * cntM
    min += '1' + '0' * (cntM-1) + '5' if cntM != 0 else '5'
    cntM = 0

if cntM != 0:
    max += '1' * (cntM)
    min += '1' + '0' * (cntM-1)
print(max)
print(min)