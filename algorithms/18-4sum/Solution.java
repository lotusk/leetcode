class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList();
        for (int i=0;i<nums.length-3 && (nums[i]<0 ||nums[i] <=target);i++){
            if(i==0|| nums[i]!=nums[i-1]){
                for (int j=i+1;j<nums.length-2  && (nums[j]<0||(nums[i]+nums[j]) -target<=0); j++ ){
                     // System.out.println(i+":"+j);
                    if(j==i+1 ||nums[j]!=nums[j-1]){
                        twoSum(nums,i,j,target,result);
                    }
                }
            }
            
        }       
        return result;   
    }
    
    void twoSum(int[] nums,int i,int j,int target,List<List<Integer>> result){
        int low=j+1;
        int high=nums.length-1;
        
        while(low<high){
            // System.out.println("-----"+low+"--"+high);
            int s=nums[i]+nums[j]+nums[low]+nums[high]-target;
            if (s <0 || (low!=j+1 && nums[low]==nums[low-1] )){
                low++;
            }else if( s>0||( high != nums.length-1 && nums[high]==nums[high+1])){
                high--;
            }else{
                result.add(Arrays.asList(nums[i],nums[j],nums[low++],nums[high--]));
            }
        }
    }
}
