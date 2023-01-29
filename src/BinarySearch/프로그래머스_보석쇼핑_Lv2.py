from collections import Counter, defaultdict
# 매 반복마다 counter를 쓰면 시간초과
# start = 0, end = len(gems)에서 시작하는 것은 최적의 답을 찾지 못한다
def solution(gems):
    
    start, end = 0, 0
    answer = [start, len(gems)]
    gem_len, gem_kinds = len(gems), len(set(gems))
    gem_dict = defaultdict(lambda: 0) # 구매하는 범위 안에 존재하는 보석 개수
    # left, right로 나눠서 하나씩 줄여가며 탐색
    while True:
        # start를 기준으로 끝까지 탐색했을 때 종료
        if start == gem_len:
            break;
        cur_kinds = len(gem_dict)
        # 모든 종류가 들어있다
        if cur_kinds == gem_kinds:
            if end - start < answer[1] - answer[0]:
                answer[0], answer[1] = start, end
            gem_dict[gems[start]] -= 1
            if gem_dict[gems[start]] == 0:
                del gem_dict[gems[start]]
            start += 1
            continue
        if end == gem_len:
            break
        if cur_kinds != gem_kinds:
            gem_dict[gems[end]] += 1
            end += 1
            continue

    answer[0] += 1

    return answer

print(solution(['aaa', 'bbb', 'avsvd', 'asdfc', 'aaa']))