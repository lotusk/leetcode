# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        result= ListNode(0)
        result_tail= result
        carry=0
        
        while l1 or l2 or carry:
            sums = (l1.val if l1 else 0) +(l2.val if l2 else 0) +carry
            carry,val=divmod(sums,10)
            result_tail.next = ListNode(val)
            result_tail = result_tail.next
            l1=(l1.next if l1 else None)
            l2=(l2.next if l2 else None)          
            
        # if carry ==1:
        #     result_tail.next = ListNode(1)
        return result.next
    
    def addTwoNumbers2(self, l1: ListNode, l2: ListNode) -> ListNode:
        # print(l1)
        result= ListNode(0)
        result_tail= result
        carry=0
        while True:
            # print(l1.val)
            # print(l2.val)
            sums = (l1.val if l1 else 0) +(l2.val if l2 else 0) +carry
            if sums >= 10:
                carry =1 
            else :
                carry =0
            result_tail.val = sums % 10
            
            l1=(l1.next if l1 else None)
            l2=(l2.next if l2 else None)
            
            if not (l1 or l2):
                break
                
            result_tail.next = ListNode(0)
            result_tail = result_tail.next
            
        if carry ==1:
            result_tail.next = ListNode(1)
        return result
            
        
