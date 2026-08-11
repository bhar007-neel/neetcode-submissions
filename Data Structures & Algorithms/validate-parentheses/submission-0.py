class Solution:
    def isValid(self, s: str) -> bool:
        stack =[]

        pairs = {
            ')': '(',
            '}': '{',
            ']': '['
        }

        for char in s:
            if char in pairs:  # closing bracket
                if not stack or stack.pop() != pairs[char]:
                    return False
            else:              # opening bracket
                stack.append(char)

        return len(stack) == 0