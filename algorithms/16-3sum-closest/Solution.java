class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest=Integer.MAX_VALUE;
        for (int i=0; i<nums.length-2; i++){
            if(i==0 ||nums[i]!=nums[i-1]){
                int temp=twoSum(nums,i,target,closest);
                if(temp==0){
                    return target;
                }else{
                    closest = Math.min(temp,closest);
                    if(Math.abs(temp) < Math.abs(closest)){
                        closest = temp;
                    }
                    
                }
            }
            if(nums[i]-target>0){
                break;
            }
        }
        // System.out.println(closest);
        return target+closest;
    }
    
    int twoSum(int[] nums,int i,int target,int closest){
        int low=i+1;
        int high=nums.length-1;
        
        while(low<high){
            // System.out.println("-----"+low+"--"+high);
            int s=(nums[i]+nums[low]+nums[high])-target;
            if (s <0 || (low!=i+1 && nums[low]==nums[low-1] )){
                if(Math.abs(s) < Math.abs(closest)){
                    closest = s;
                }
                low++;
            }else if( s>0||( high != nums.length-1 && nums[high]==nums[high+1])){
                if(Math.abs(s) < Math.abs(closest)){
                    closest = s;
                }
                high--;
            }else{
                return 0;
            }
        }
        return closest;
    }
}
