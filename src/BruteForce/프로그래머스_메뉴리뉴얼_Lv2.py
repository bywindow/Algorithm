from collections import Counter
from itertools import combinations


def solution(orders, course):
    answer = []
    # sort order each element
    for i in range(len(orders)):
        orders[i] = ''.join(sorted(orders[i]))
    # combination
    # 모든 order에 대해 조합을 구하고, Counter로 같은 것들의 숫자를 센다
    for c in course:
        cur = []
        for order in orders:
            comb = combinations(order, c)
            cur += comb
        # print(cur)
        cnt = Counter(cur)
        # print(cnt)
        if len(cnt) != 0 and max(cnt.values()) > 1:
            for res in cnt:
                if cnt[res] == max(cnt.values()):
                    answer.append(''.join(res))
                    print(answer)
    return sorted(answer)

orders = ['ABCDE', 'AB', 'CD', 'ADE', 'XYZ', 'XYZ', 'ACD']
course = [2, 3, 5]
print(solution(orders, course))
