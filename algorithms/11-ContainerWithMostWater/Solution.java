class Solution {
    public int maxArea(int[] height) {
        if(height==null || height.length==0){
            return 0;
        }
        int i=0;
        int j=height.length-1;
        int result =0;
        while (i <j){
            int x = height[i];
            int y = height[j];
            int temp = Math.min(x,y)*(j-i);
            if(temp > result){
                result= temp;
            }
            if (height[i] < height[j]){
                i++;
            }    
            else if (height[i] > height[j]){
                j--;
            }else{
                i++;j--;
            }
                
        }
        return result;
    }
}
