import collections
from typing import Deque, Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def isPalindrome(self, head: Optional[ListNode]) -> bool:
    dq: Deque = collections.deque()
    # 예외처리
    if not head:
        return True
    cur = head
    while cur is not None:
        dq.append(cur.val)
        cur = cur.next
    # 동시에 2개를 꺼내므로 1보다 커야된다.
    while len(dq) > 1:
        if dq.popleft() != dq.pop():
            return False
    return True