from functools import reduce
class Solution:      
    #Vertical scanning
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs)==0: return ""
        if len(strs)==1: return strs[0]
        i=0;
        minLen=reduce(min,[len(s) for s in strs])
        # print(minLen)
        while i< minLen:
            for j in range(1,len(strs)):
                if strs[j][i] != strs[0][i]:
                    return strs[0][:i]
            
            i=i+1

        return strs[0][:minLen]
        
