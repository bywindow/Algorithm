from typing import List


def permute(nums: List[int]):
    result = []
    perm = []

    def dfs(items):
        if len(items) == 0:
            result.append(perm[:])
            return
        for i in items:
            next_items = items[:]
            next_items.remove(i)
            perm.append(i)
            dfs(next_items)
            perm.pop()
    
    dfs(nums)

    return result
