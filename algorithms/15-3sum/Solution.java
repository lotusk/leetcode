class Solution {
    //two pointers
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList();
        
        for (int i=0; i<nums.length-2 && nums[i]<=0; i++){
            if(i==0 ||nums[i]!=nums[i-1]){
                twoSum(nums,i,result);
            }
        }
        return result;
    } 
    
    void twoSum(int[] nums,int i,List<List<Integer>> result){
        int low=i+1;
        int high=nums.length-1;
        
        while(low<high){
            // System.out.println("-----"+low+"--"+high);
            int s=nums[i]+nums[low]+nums[high];
            if (s <0 || (low!=i+1 && nums[low]==nums[low-1] )){
                low++;
            }else if( s>0||( high != nums.length-1 && nums[high]==nums[high+1])){
                high--;
            }else{
                result.add(Arrays.asList(nums[i],nums[low++],nums[high--]));
            }
        }
    }
    
    // hash tab 
    public List<List<Integer>> threeSum2(int[] nums) {
        Map<Integer,List<Integer>> supplements =new HashMap<Integer,List<Integer>>();
        for(int i=0;i<nums.length;i++){
            List<Integer> s=supplements.getOrDefault(-nums[i],new LinkedList());
            s.add(i);
            supplements.put(-nums[i],s);               
        }
        // System.out.println(supplements);
        
        List<List<Integer>> result=new ArrayList();
        
        // change to boolean[][]
        HashSet<Pair<Integer,Integer>> exist =new HashSet<Pair<Integer,Integer>>();
        
        
        HashSet<Integer> processOne=new HashSet<Integer>();
        for(int i=0;i<nums.length-2;i++){
            if(processOne.contains(nums[i])){
                continue;
            }
            for(int j=i+1;j<nums.length;j++){
                Pair key=nums[i]<=nums[j]? new Pair(nums[i],nums[j]) :new Pair(nums[j],nums[i]);
                if(exist.contains(key)){
                    // System.out.println("--");
                    continue;
                }
                
                List<Integer> answers= supplements.get(nums[i]+nums[j]);
                if(answers!=null){
                    for(Integer a:answers){
                        if (a!=i &&a!=j){
                            List<Integer> r=Arrays.asList(nums[i],nums[j],nums[a]);
                            Collections.sort(r);
                            result.add(r);
                            // result.add(Arrays.asList(nums[i],nums[j],nums[a]));
                            exist.add(new Pair(r.get(0),r.get(1)));
                            exist.add(new Pair(r.get(0),r.get(2)));
                            exist.add(new Pair(r.get(1),r.get(2)));
                            break;
                        }
                    // System.out.println(a);
                    }
                }
                
            }
                 
            processOne.add(nums[i]);
        } 
        return result;        
    }
}
