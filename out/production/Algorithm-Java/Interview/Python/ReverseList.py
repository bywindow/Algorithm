class ListNode:
    def __init__(self, val = 0, next = None) -> None:
        self.val = val
        self.next = next
class Solution:
    def solution(head: ListNode):


        #반복문
        node, prev = head, None

        while node:
            next, node.next = node.next, prev
            prev, node = node, next
        
        return prev


        # 재귀풀이
        def reverse(node: ListNode, prev: ListNode = None):
            if not node:
                return prev
            next, node.next = node.next, prev

            return reverse(next, node)
        
        return reverse(head) 

        