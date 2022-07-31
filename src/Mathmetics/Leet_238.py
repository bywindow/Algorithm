from typing import List

def productExceptSelf(self, nums: List[int]) -> List[int]:
    left, right = [], []
    left.append(1)
    right.append(1)
    for i in range(1, len(nums)):
        left.append(left[i-1]*nums[i-1])
        right.append(right[i-1]*nums[len(nums)-i])
    right = right[::-1]
    answer = [];
    for i in range(len(nums)):
        answer.append(left[i] * right[i])
    return answer
