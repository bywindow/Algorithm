"""
A와 B를 각각 정렬 -> 처음 정렬된 배열을 돌면서 result 계산 -> 첫번째 원소를 마지막으로 옮기며 result를 계산하고 작은 값이 나오면 반복 종료
오름차순으로 정렬하면 시간초과가 난다.
내림차순으로 해서 그리디하게 풀어야 됨
"""

def solution(A, B):
    answer = 0
    A.sort(reverse = True)
    B.sort(reverse = True)

    for i in range(len(A)):
        if A[i] < B[0]:
            answer += 1
            del B[0]
        else:
            continue

    return answer

print(solution([5,1,3,7], [2,2,6,8]))