class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1size=nums1.length;
        int num2size=nums2.length;
        int[] A,B;
        int m,n;
        if(num1size <= num2size){
            m = num1size;
            n = num2size;
            A= nums1;
            B= nums2;
        }else{
            m = num2size;
            n = num1size;
            A= nums2;
            B= nums1;
        }
         
        // System.out.println(String.format("%s,%s",m,n));
        // System.out.println(String.format("%s,%s",A.length,B.length));
        int imin=0;
        int imax=m;
        int half=(m+n+1)/2;
        boolean isOdd =(m+n) %2 !=0;
        while (imin <= imax){
            int i= (imin+imax)/2;
            int j= half-i;
            
            if(i<m &&B[j-1]>A[i]){
                imin++;
            }else if(i>0 && A[i-1]>B[j]){
                imax--;
            }else{
                if(isOdd){
                    return getMaxLeft(A,B,i,j);
                }else{
                    return (getMaxLeft(A,B,i,j)+getMinRight(A,B,i,j))/2.0;
                }
            }
        }
        return 0;
    }
    
    public int getMaxLeft(int[] A,int[]B,int i,int j){
        if(i>0 &&j >0){
            return Math.max(A[i-1],B[j-1]);
        }else if(j>0){
            return B[j-1];
        }else {
            return A[i-1];
        }
    }
    
    public int getMinRight(int[] A,int[]B,int i,int j){
        if(i<A.length && j<B.length){
            return Math.min(A[i],B[j]);
        }else if(i < A.length){
            return A[i];
        }else{
            return B[j];
        }
    }
}
