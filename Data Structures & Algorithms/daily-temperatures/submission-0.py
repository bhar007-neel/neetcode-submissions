from typing import List

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0] * len(temperatures)
        stack = []  # Stores indexes of days waiting for a warmer day

        for current_day, current_temp in enumerate(temperatures):

            while stack and current_temp > temperatures[stack[-1]]:
                previous_day = stack.pop()
                result[previous_day] = current_day - previous_day

            stack.append(current_day)

        return result