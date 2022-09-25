import sys

n, w, l = map(int, sys.stdin.readline().split()) # 한 줄을 읽어와 공백을 기준으로 나누고 int로 매핑
trucks = list(map(int, sys.stdin.readline().split()))

curL = 0 # 현재 다리위에 몇 l이 올라와있는지
answer = 0
bridge = [0] * w # 다리 길이만큼 칸을 만든다

while True:
    # 다리의 가장 왼쪽에 있는 트럭 제거
    fin = bridge.pop(0)
    curL -= fin

    answer += 1

    if trucks:
        # 트럭이 올라올 수 있는지 확인
        if curL + trucks[0] <= l:
            # 다리에 추가
            curT = trucks.pop(0)
            bridge.append(curT)
            curL += curT
        else:
            bridge.append(0)
    if not bridge:
        break
print(answer)