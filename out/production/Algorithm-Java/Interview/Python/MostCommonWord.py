from collections import Counter
import re
from typing import List


def solution(paragraph: str, banned: List[str]):
    words = [w for w in re.sub(r'[^\w]', ' ', paragraph).lower().split() if w not in banned]
    counts = Counter(words)
    return counts.most_common(1)[0][0]
