class Solution:
    def maxArea(self, height: List[int]) -> int:
        left =0
        right = len(height) -1
        maxWater=0
        while(left<right):
            width = right - left
            Curr_height = min(height[right], height[left])
            area = width* Curr_height
            maxWater = max(area, maxWater)
        
        
            if(height[left]<height[right]):
                left= left +1
            else:
                right = right -1

        return maxWater