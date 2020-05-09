class Roman{
    private char name;
    private int value;
    
    public char getName(){
        return this.name;
    }
    public int getValue(){
        return this.value;
    }
    
    public Roman(char name,int value){
        this.name = name;
        this.value = value;
    }
    public String toString(){
        return String.format("{%s:%s}",name,value);
    }
}

class Solution {
    public String intToRoman(int num) {
        List<Roman> romans=List.of(new Roman('M',1000),new Roman('D',500),new Roman('C',100),new Roman('L',50),new Roman('X',10),new Roman('V',5),new Roman('I',1));
        Map<Character,Character> special= Map.of('M','C','D','C','C','X','L','X','V','I','X','I'); 
        StringBuilder sb=new StringBuilder();
        int tail=num;
        for(int i=0;i<romans.size();i++){
            char c=romans.get(i).getName();
            int n =romans.get(i).getValue();
            while(tail >=n){
                sb.append(c);
                tail-= n;
            }
            
            if((c=='V'||c=='L'||c=='D') && tail + n/5 >=n){
                sb.append(special.get(c));
                sb.append(c) ;
                tail -= n*0.8;        
            }
       
                
            if((c=='M'||c=='C'||c=='X' )&& tail +  n/10 >=n){
                sb.append(special.get(c));
                sb.append(c) ;
                tail -= n*0.9;        
            }
        }
        
        
        return sb.toString();
    }
}
