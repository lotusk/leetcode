class Solution {
    public String convert(String s, int numRows) {
        if(numRows <=1 || s.length()<numRows){
            return s;
        }
        StringBuilder builder=new StringBuilder();
        int n=s.length();
        int cycle= numRows*2 -2;
        for (int i=0;i<numRows;i++){
            for(int j=0;i+j<n;j+=cycle){
                builder.append(s.charAt(i+j));
                if(i!=0 && i!=numRows-1 && j+cycle-i <n){
                    builder.append(s.charAt(j+cycle-i));
                }
            }
        }
        return builder.toString();
    }
//     public String convert(String s, int numRows) {
//         if(numRows <=1 || s.length()<numRows){
//             return s;
//         }
        
//         StringBuilder[] rows=new StringBuilder[numRows];
//         for (int i=0; i <numRows;i++){
//             rows[i]=new StringBuilder();
//         }
//         for (int i=0 ;i <s.length(); i++){
//             int mod=i % (numRows*2 -2);
//             // System.out.println(mod);
//             if(mod < numRows){
//                 rows[mod].append(s.charAt(i));
//             }else{
//                 rows[numRows*2-mod-2].append(s.charAt(i));
//             }
//         }
//         StringBuilder result=new StringBuilder();
//         for (int i=0; i <numRows;i++){
//             result.append(rows[i]);
//         }
//         return result.toString();
//     }
}
