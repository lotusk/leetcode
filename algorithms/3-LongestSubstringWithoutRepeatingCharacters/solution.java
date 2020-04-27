class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; 

        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
            // System.out.println(index[s.charAt(j)]);
        }
        return ans;
    }
//     public int lengthOfLongestSubstring(String s){
//         int maxresult=0;
//         Map<Character,Integer> map = new HashMap<>();
//         int n= s.length();
        
//         for(int i=0,j=0;j<n ;j++){
//              Character c=s.charAt(j);
//             if(map.containsKey(c)){
//                 i=Math.max(map.get(c)+1,i);
//             }

//             map.put(c,j);
//             // System.out.println("i:"+i+"j:"+j);
//             maxresult=Math.max(maxresult,j-i +1 );
//         }
//         return maxresult;
//     }
    
//         public int lengthOfLongestSubstring(String s) {
//             int maxresult=0,i=0,j=0;
//             Map<Character,Integer> map = new HashMap<>();
//             int n= s.length();
            
//             while(i < n && j <n){
//                 Character c=s.charAt(j);
//                 if(map.containsKey(c)){
//                     i=Math.max(map.get(c)+1,i);
//                 }
                
//                 map.put(c,j);
//                 j++;
//                 // System.out.println("i:"+i+"j:"+j);
//                 maxresult=Math.max(maxresult,j-i );
//             }
//         return maxresult;
            
        // }
    
//     public int lengthOfLongestSubstring(String s) {
//         int maxresult=0,i=0,j=0;
//         Set<Character> set = new HashSet<>();
//         int n= s.length();
//         while(i < n && j <n){
//             Character c=s.charAt(j);
//             if(set.contains(c)){
//                 set.remove(s.charAt(i));
//                 i++;
                
//             }else{
//                 set.add(c);
//                 j++;
//                 // System.out.println("i:"+i+"j:"+j);
//                 maxresult=Math.max(maxresult,j-i );
//             }
//         }
//         return maxresult;
        
//     }
//     public int lengthOfLongestSubstring(String s) {
//         int len= s.length();
//         int maxresult=0;
//         for(int i =0; i < len;i++){
//             // System.out.println(i);
//             for(int j=i+1;j <=len;j++){
                
//                 if(allUnique(s,i,j)){
//                     // System.out.println("i:"+i+"j:"+j);   
//                     maxresult= Math.max(maxresult,j-i );
//                 }
//             }   
//         }
//         return maxresult  ;
//     }
    
//     public boolean allUnique(String s,int start ,int end){
//         Set<Character> set = new HashSet<>();
//         for(int i=start; i <end;  i++){
//             Character c=s.charAt(i);
//             if(set.contains(c)) return false;
            
//             set.add(c);
//         }  
//         return true;
//     }
}
