from io import StringIO
class Solution:
    def intToRoman(self, num: int) -> str:
        dicts=[('M',1000),('D',500),('C',100),('L',50),('X',10),('V',5),('I',1)]
        special={'M':'C','D':'C','C':'X','L':'X','V':'I','X':'I'}
        result =StringIO()
        tail = num
        for (c,n) in dicts:
            while tail >= n:
                result.write(c)
                tail = tail -n
            
            if c in ['V','L','D'] and tail + n/5 >=n:
                result.write(special[c]+c)
                tail = tail -int(n*0.8)
                
            if c in ['M','C','X'] and tail + n/10 >=n:
                result.write(special[c]+c)
                tail = tail -int(n*0.9)
           
        return result.getvalue()
        # (d,m)=divmod(num)
        
