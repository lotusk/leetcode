class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if len(s)<= numRows or numRows<=1:return s
 
        from io import StringIO
        rows = [StringIO() for i in range(numRows)]
        for i in range(len(s)):
            mod = i % (numRows*2-2)
            if(mod < numRows):
                rows[mod].write(s[i])
            else:
                rows[numRows-mod-2].write(s[i])
            
        return ''.join([r.getvalue() for r in rows])
            
        
