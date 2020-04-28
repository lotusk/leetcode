import numpy as np
def isPalindromic(s):
        for i in range(int((len(s)+1)/2)+1):
            if s[i] !=s[len(s)-i-1]: return False
            
        return True
    

class Solution:
    def longestPalindrome(self, s: str) -> str:
        if (not s) and len(s) <=0: return ""
        start,end=0,0
        for i in range(len(s)):
            len1=self.expandFromCenter(s,i,i)
            len2=self.expandFromCenter(s,i,i+1)
            
            lens =max(len1,len2)
            # print(lens)
            # print(start,end)
            if(lens > end-start):
                end=int(lens/2) + i
                start= i- int((lens-1)/2 )
                # print("end:",start,end)
                
        
        return s[start+1:end]
            
    def expandFromCenter(self,s:str,left:int,right:int):
        i,j=left,right
        while i>=0 and j<len(s) and s[i]==s[j] :
            i=i-1
            j=j+1
            
        return j-i +1
            
        
      #dynamic process  
#     def longestPalindrome(self, s: str) -> str:
#         n=len(s)
#         cache_result=np.zeros((n,n),np.bool)
#         maxlen=0
#         maxi,maxj=0,0
#         for j in range(1,len(s)):
#             for i in range(j):
#                 # print(i,j,s[i:j+1],isPalindromic(s[i:j+1])) 
#                 if (j==i+1  or j==i+2 or cache_result[i+1][j-1] ) and s[i]==s[j]:
#                     cache_result[i][j]=True
#                     if(j+1-i > maxlen):
#                         maxlen=j+1-i
#                         maxi,maxj=i,j
                        

#         # print(i,j)        
#         return s[maxi:maxj+1]
            
    
    
#     def longestPalindrome(self, s: str) -> str:
#         maxlen=0
#         maxi,maxj=0,0
#         for i in range(len(s)-1):
#             for j in range(i+1,len(s)):
#                 # print(i,j,s[i:j+1],isPalindromic(s[i:j+1]))
#                 if (isPalindromic(s[i:j+1])):
#                     if(j+1-i > maxlen):
#                         maxlen=j+1-i
#                         maxi,maxj=i,j
        
#         return s[maxi:maxj+1]
        
    
