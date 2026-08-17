class Solution:
    def isValid(self, s:str)-> bool:
        stack = []

        pairs = {
            ')': '(',
            '}': '{',
            ']': '['

        }

        for i in s:
            if i in pairs:
                #If the stack is empty OR the top item we remove from the stack does not match what we expected, return False.
                if not stack or stack.pop() != pairs[i]:
                    return False 
                    
            else:
                stack.append(i)

        return len(stack) == 0
            