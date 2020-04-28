def get_max_from_arrays(arr1 ,index1,arr2 ,index2):
        if index1 == 0:
            return float(arr2[index2-1])
    
    
        if index2==0:
            return float(arr1[index1-1])
      
        return max(arr1[index1-1],arr2[index2-1])
    
def get_min_from_arrays(arr1,index1,arr2,index2):
    if index1 == len(arr1):
        return arr2[index2]
    if index2 == len(arr2):
        return arr1[index1]
    
    return min(arr1[index1],arr2[index2])
    
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums1Size=len(nums1)
        nums2Size=len(nums2)
        if nums1Size <= nums2Size:
            m,n = nums1Size,nums2Size
            A,B = nums1, nums2
        else:
            m,n = nums2Size,nums1Size
            A,B = nums2, nums1
        
        
        imin ,imax, half=0,m,int((m+n+1)/2)
        
        isOdd = (m+n) % 2 !=0
        
        while True :
            i = int((imin+imax)/2)
            j = half - i
            print(i,j)
            if (j==0 or i==m or B[j-1] <= A[i]) and (i==0 or j==n or A[i-1] <=B[j]):
                if isOdd:
                    print("odd:",i,j)
                    return get_max_from_arrays(A,i,B,j)
                else:
                    return (get_max_from_arrays(A,i,B,j)+ get_min_from_arrays(A,i,B,j))/2
                
            elif B[j-1] >A[i]:
                imin=i+1
                print(imin)
                
            elif A[i-1] >B[j]:
                imax=i-1
        
        return 0.0
    
    
    
        
