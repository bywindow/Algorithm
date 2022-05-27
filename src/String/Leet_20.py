class Solution:
    def isValid(self, s: str) -> bool:
        brackets = {'(': 1, ')': -1, '{': 2, '}': -2, '[': 3, ']': -3} #dict
        cur = [brackets[s[0]]]
        for i in range(1, len(s)):
            if brackets[s[i]] < 0:
                if len(cur) == 0:
                    return False
                if cur[len(cur)-1] * (-1) != brackets[s[i]]:
                    return False
                else:
                    cur = cur[:len(cur)-1]
            else:
                cur.append(brackets[s[i]])
        return True if len(cur) == 0 else False
