# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        p1 = list1 # pointer of list1
        p2 = list2 # pointer of list2
        cur = ListNode(0)
        answer = cur
        # iteration
        while p1 and p2:
            if p1.val < p2.val:
                cur.next = p1
                p1 = p1.next
            else:
                cur.next = p2
                p2 = p2.next
            cur = cur.next
        # left
        if p1:
            cur.next = p1
        if p2:
            cur.next = p2
        return answer.next