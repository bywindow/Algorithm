from typing import List

def arrayPairSum(self, nums: List[int]) -> int:
    return sum(sorted(nums)[::2])