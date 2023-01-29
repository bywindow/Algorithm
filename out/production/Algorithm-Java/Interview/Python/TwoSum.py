from typing import List


def solution(nums: List[str], target: int):
    nums_map = {}
    for i, num in enumerate(nums):
        nums_map[num] = i
    
    for i, num in enumerate(nums):
        if target - num in nums_map and i != nums_map[target - num]:
            return nums.index(num), nums_map[target - num]

    # 투 포인터
    nums.sort() # 인덱스를 찾는 문제라면 정렬하면 안된다.
    left, right = 0, len(nums) - 1
    while not left == right: 
        if nums[left] + nums[right] < target:
            left += 1
        elif nums[left] + nums[right] > target:
            right -= 1
        else:
            return left, right
        