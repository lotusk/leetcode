class Solution {
    public String longestPalindrome(String s) {
        if(s ==null || s.length()==0){
            return "";
        }
        int start=0;
        int end=0;
        for(int i=0;i < s.length();i++){
            int len1= expandFromCenter(s,i,i);
            int len2= expandFromCenter(s,i,i+1);
            int len=Math.max(len1,len2);
            
            if(len > end -start){
                end= len/2 +i;
                start =i - (len-1)/2;
            }
        }
        
        return s.substring(start,end+1);
        
    }
    
    public int expandFromCenter(String s,int left,int right){
        int i=left;
        int j=right;
        while(i>=0 && j <s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
}
