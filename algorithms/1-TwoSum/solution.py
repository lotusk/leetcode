class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map={}
        for i,v in enumerate(nums):
            complement = target -v
            if complement in map:
                return [map[complement],i]
            
            map[v]=i

            
#     def twoSum1(self, nums: List[int], target: int) -> List[int]:
#         map={}
#         for i,v in enumerate(nums):
#             map[v]=i
            
#         for i,v in enumerate(nums):
#             complement = target -v
#             print(complement)
#             if complement in map and map[complement] != i:
#                 return [i,map[complement]]
        
    
#     def twoSum2(self, nums: List[int], target: int) -> List[int]:
#         for i in range(len(nums)):
#             for j in range(i+1,len(nums)):
#                 if nums[i] + nums[j]== target:
#                     return[i,j]
                
#         return None
        
