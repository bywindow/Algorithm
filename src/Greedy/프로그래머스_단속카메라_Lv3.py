"""
[0] 기준으로 정렬 -> 차량의 개수가 100000대 이하라서 이중for문 + 그리디로 풀어보자
"""
def solution(routes):
    answer = 0
    routes.sort(key=lambda x: x[1])
    # print(routes)
    # 진출지점에 카메라를 설치한다
    # 뒤에 있는 차의 진입시점이 앞 차의 진입시점보다 빠르면 카운트하지 않는다
    end = -30001
    for i in range(len(routes)):
        if routes[i][0] <= end:
            continue
        answer += 1
        end = routes[i][1]
    
    return answer

print(solution([[-20,-15], [-14,-5], [-18,-13], [-5,-3]]))
print(solution([[-100,100],[50,170],[150,200],[-50,-10],[10,20],[30,40]]))