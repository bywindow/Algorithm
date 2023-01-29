"""
입차한 후 출차 내역이 없다면 23:59에 출차한 것으로 판단
누적 주차시간으로 요금 계산
기본시간 이하라면 기본요금만. 초과한 시간에 대해서 단위 시간만다 단위 요금
"""

from collections import defaultdict
import math


def solution(fees, records):
    defaultMin, defaultFee, unitTime, unitFee = fees[0], fees[1], fees[2], fees[3]
    dict = {} # 현재 입차되어 있는 차의 번호와 시간
    result = defaultdict(int) # 차량 번호에 따라 누적 주차시간 기록
    for record in records:
        info = record.split()
        # print(info)
        hour, minute = info[0].split(":")
        time = int(hour) * 60 + int(minute) # tiemstamp 개념과 비슷하게 계산
        # print(time)
        if info[1] in dict:
            # print(dict.keys())
            # 입차되어 있다면 주차시간 기록
            result[info[1]] += time - dict[info[1]]
            del dict[info[1]]
        else:
            dict[info[1]] = time
    
    # 나가지 않고 입차되어 있다면
    endTime = 23 * 60 + 59
    for number in dict.keys():
        # print(number)
        result[number] += endTime - dict[number]
    
    answer = []
    for number, time in result.items():
        fee = 0
        if time <= defaultMin:
            fee = defaultFee
        else:
            fee = defaultFee + math.ceil((time-defaultMin)/unitTime) * unitFee
        answer.append((number, fee))
    answer.sort()
    for i in range(len(answer)):
        answer[i] = answer[i][1]
        
    return answer

fees = [180, 5000, 10, 600]
records = ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]

print(solution(fees, records))