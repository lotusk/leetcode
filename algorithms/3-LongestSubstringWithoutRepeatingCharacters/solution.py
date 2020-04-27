class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        point=0
        tempMap={}
        longest=0
        for i in range(len(s)):
            if(s[i] in tempMap):
                longest = max(i-point,longest)
                point = tempMap[s[i]]+1
                tempMap={}
                for j in range(point,i+1):
                    tempMap[s[j]]=j
            else:                
                tempMap[s[i]]=i
            

        return max(len(s)-point,longest)
        
