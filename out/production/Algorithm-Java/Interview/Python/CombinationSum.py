from typing import List


def combinationSum(candidates: List[int], target: int):
    result = []

    def dfs(cur_sum, index, path):
        if cur_sum > target:
            return
        if cur_sum == target:
            result.append(path[:])
            return
        
        for i in range(index, len(candidates)):
            dfs(cur_sum+candidates[i], i, path+[candidates[i]])
        
    dfs(target, 0, [])
    return result