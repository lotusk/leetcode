class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        mem={}
        def dp(i,j):
            if(i,j) not in mem:
                if not p[j:] :
                    mem[i,j]=not s[i:]   
                    return mem[i,j]
                first_match= bool(s[i:]) and p[j] in [s[i],'.','*']
                if len(p)-j >=2 and p[j+1]=="*":
                    mem[i,j] = (first_match and dp(i+1,j)) or dp(i,j+2) 
                else:
                    mem[i,j]= first_match and dp(i+1,j+1)
                
            return mem[i,j]
                
        return dp(0,0)
    
    def isMatch2(self, s: str, p: str) -> bool:
        if not p :return not s    
        first_match= bool(s) and p[0] in [s[0],'.','*']
        if len(p)>=2 and p[1]=="*":
            return (first_match and self.isMatch(s[1:],p)) or self.isMatch(s,p[2:])         
        else:
            # first_match= bool(s) and p[0] in [s[0],'.','*']
            return first_match and self.isMatch(s[1:],p[1:])
            
     
