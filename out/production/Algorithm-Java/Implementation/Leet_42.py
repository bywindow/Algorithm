def trap(self, height: List[int]) -> int:
    # 좌측, 우측 두개의 포인터가 있고
    # 각각 좌에서 우로, 우에서 좌로 이동하면서 가장 높은 것에서 현재의 값을 빼 저장해둔다
    # 두 배열의 각 인덱스에서 최소의 값들을 더한다.
    fromLeft = [0 for _ in range(len(height))]
    fromRight = [0 for _ in range(len(height))]
    leftMax, rightMax = height[0], height[len(height)-1]
    for i in range(len(height)):
        left, right = height[i], height[len(height)-1-i]
        leftMax, rightMax = max(leftMax, left), max(rightMax, right)
        fromLeft[i], fromRight[len(height)-1-i] = leftMax - left, rightMax - right
    answer = 0;
    for i in range(len(height)):
        answer += min(fromLeft[i], fromRight[i])
    return answer