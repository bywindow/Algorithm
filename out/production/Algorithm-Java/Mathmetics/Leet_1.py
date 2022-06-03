from typing import List

class Leet_twoSum:
  def twoSum(self, nums: List[int], target: int) -> List[int]: 
    for i in range(len(nums)-1) :
      for j in range(i+1, len(nums)) :
        if nums[i] + nums[j] == target :
          return [i, j]

  # nums = [2, 7, 11, 15]
  # target = 9
  # print(twoSum(nums=nums, target=target))

main = Leet_twoSum()
nums = [2, 7, 11, 15]
target = 9
print(main.twoSum(nums, target))

###################
# 파이썬의 클래스 안에 정의된 self는 객체의 인스턴스 그 자체를 말한다
# 객체 자기 자신을 참조하는 매개변수이다.
# 그래서 클래스 밖에서 클래스 안에 정의된 함수를 사용할 경우
# 객체의 인스턴스를 하나 생성해서 위와 같은 방법으로 사용해야 한다.