class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x>=0 and int(x/10) ==0:return True;
        if x<0 or x%10==0:return False;
        t=0
        while x>t:
            x,mod=divmod(x,10)
            t=t*10+mod
            print (x,t)
         
        
        return t==x or int(t/10) ==x
