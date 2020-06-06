class Solution {
     Map<Character, Character> m = new HashMap<Character, Character>() {{
        put('{', '}');
        put('(', ')');   
        put('[', ']');   
     }};
    public boolean isValid(String s) {
        Stack stack=new Stack();
        for (int i =0;i<s.length();i++){
            if(s.charAt(i)=='{' ||s.charAt(i)=='('|| s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else if (i!=0 &&!stack.empty() && m.get(stack.peek()).equals(s.charAt(i))){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.empty();
    }
}
