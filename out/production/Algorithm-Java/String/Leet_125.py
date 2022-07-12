class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower() # change to lowercase
        arr = []
        for cur in s:
            if cur.isalnum(): # alphabet or number ?
                arr.append(cur)
        return arr == arr[::-1]