class Solution {
    public int reverse(int x) {
        int base=1;
        if(x <0){
            base=-1;
            x= -x;
        }
        long result=0;
        for(long b=x; b>0; b /= 10){
            // System.out.println(b);
            result= result*10 +(b %10);
        }
        
        if(result*base <=Integer.MAX_VALUE && result*base >=Integer.MIN_VALUE){
            return (int)result*base;
        }else{
            return 0;
        }
    }
}
