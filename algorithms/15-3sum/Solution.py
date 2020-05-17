class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        
        supplements ={}
        for i in range(len(nums)):
            s = supplements.get(-nums[i],[])
            s.append(i)
            supplements[-nums[i]]=s
            
            
        result=[]
        # resultSet=set()
        exist=set()
        processOne=set()
        for i in range(len(nums)):
            if nums[i] in processOne:
                    continue
            for j in range(i+1,len(nums)):
                key = (nums[i],nums[j]) if nums[i] <= nums[j] else (nums[j],nums[i])
                if key in exist:
                    continue
                answer=supplements.get(nums[i]+nums[j])
                if answer and len(answer) > 0:
                    for a in answer:                        
                        if a not in [i,j]:
                            ans=[nums[i],nums[j],nums[a]]
                            ans.sort()
                            exist.add((ans[0],ans[1]))
                            exist.add((ans[0],ans[2]))
                            exist.add((ans[1],ans[2]))
                            result.append(ans)
                            break;
                            # if tuple(ans) not in resultSet:
                            #     result.append(ans)
                            #     resultSet.add(tuple(ans))
                                
                processOne.add(nums[i])
                # print(answer)
                
        
        return result
