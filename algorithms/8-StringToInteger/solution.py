class Solution:
    def myAtoi(self, str: str) -> int:
        str=str.lstrip()
        # str=str.lstrip('0')
        result = 0
        base =1
        isSigh= False;
        for i in range(len(str)):
            if str[i] <='9' and str[i] >='0':
                result=result*10 + int(str[i])
                isSigh =True
                if result*base > pow(2,31) -1:
                    return pow(2,31) -1
                elif result*base < pow(-2,31):
                    return pow(-2,31)
            elif isSigh and ( str[i]=='-' or str[i]=='+'):
                break
            elif str[i] == '-' and base==1:
                base =-1
                isSigh =True
            elif str[i] == '+' and not isSigh:
                isSigh =True
          
            else:
                break
                
        
        return result*base
            
        
