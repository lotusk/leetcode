class Solution:
    def romanToInt(self, s: str) -> int:
        dicts={'M':1000,'D':500,'C':100,'L':50,'X':10,'V':5,'I':1}
        # special={'M':'C','D':'C','C':'X','L':'X','V':'I','X':'I'}
        special={'CM':900,'CD':400,'XL':40,'XC':90,'IV':4,'IX':9}
        result =0
        i=0;
        while i<len(s):            
            if (s[i] in ['C','X','I']) and (i+1<len(s)) and (s[i:i+2] in special):
                result =result+special[s[i:i+2]]
                i=i+2
            else:
                result =result+dicts[s[i]]
                i=i+1
                
        return result
            
                
        
