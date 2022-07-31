from typing import List
import sys

def maxProfit(self, prices: List[int]) -> int:
    answer = 0
    minPrice = sys.maxsize

    for price in prices:
        minPrice = min(price, minPrice)
        answer = max(answer, price - minPrice)
    return answer