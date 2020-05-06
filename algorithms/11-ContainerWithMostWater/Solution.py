class Solution:
    def maxArea(self, height: List[int]) -> int:
        if not height or len(height)==0:
            return 0
        i=0
        j=len(height)-1
        result =0
        while i <j:
            x = height[i]
            y = height[j]
            result = max(min(x,y)*(j-i) ,result)
            if height[i] < height[j]:
                i=i+1
            elif height[i] > height[j]:
                j=j-1
            else:
                i=i+1
                j=j-1

        return result
                         
            
