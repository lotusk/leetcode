class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> dicts=Map.of('M',1000,'D',500,'C',100,'L',50,'X',10,'V',5,'I',1);
        Map<String,Integer> special=Map.of("CM",900,"CD",400,"XL",40,"XC",90,"IV",4,"IX",9);
        
        int result =0;
        int i=0;
        while (i<s.length()){
            if((i+1<s.length()) && special.containsKey(s.substring(i,i+2))){
                result += special.get(s.substring(i,i+2));
                i+=2;
            }else{
                result += dicts.get(s.charAt(i));
                i++;
            }
        }
        return result;    
    }
}
