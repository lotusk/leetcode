class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length() ]=true;
        
        for (int i= s.length();i>=0 ;i-- ){
            for(int j =p.length()-1; j>=0;j--){
                boolean firstMatch=i <s.length() && ( p.charAt(j)== s.charAt(i) || p.charAt(j)=='.');
                if( p.length() - j >=2 && p.charAt(j+1)=='*'){
                   dp[i][j]= (firstMatch && dp[i+1][j]) || dp[i][j+2];
                }else{
                    dp[i][j] =firstMatch && dp[i+1][j+1];
                }
                              
            }
        }
        // for (boolean[] ds:dp){
        //     System.out.println(Arrays.toString(ds));
        // }
        return dp[0][0];
    }
}
