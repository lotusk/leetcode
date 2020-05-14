class Solution {
    // vertical scan
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        
        // int i=0;
        int minLen=Arrays.asList(strs).stream().map(String::length).reduce(Math::min).get();
        // System.out.println(minLen);
        for(int i=0;i<minLen;i++){
            for(int j=1;j<strs.length;j++){
                // System.out.println(i);
                if(strs[j].charAt(i)!=strs[0].charAt(i)){
                    System.out.println(i);
                    return strs[0].substring(0,i);
                }
            }
        }
        // System.out.println(minLen);
        // System.out.println(strs[0].substring(0,minLen));
        return strs[0].substring(0,minLen);
    }
}
