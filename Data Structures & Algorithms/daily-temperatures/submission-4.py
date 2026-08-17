from typing import List

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0] * len(temperatures)
        stack=[]

        for cday, ctemp in enumerate(temperatures):

            while stack and ctemp > temperatures[stack[-1]]:
                previousDay = stack.pop()
                result[previousDay] = cday-previousDay

            stack.append(cday)
        return result