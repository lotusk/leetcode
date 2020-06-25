# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
def less(a,b):
    if a==None:
        return True
    if b==None:
        return False
    return a<b

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        result=ListNode()
        tail=result
        while True:
            if l1==None and l2==None:
                return result.next
            if l1==None:
                tail.next = ListNode()
                tail = tail.next
                tail.val=l2.val
                l2 = l2.next
                continue
                
            if l2==None:
                tail.next = ListNode()
                tail = tail.next
                tail.val=l1.val
                l1 = l1.next
                continue
                
            left=l1.val
            right=l2.val
            
            if left==None and right==None:
                return result.next
            
            if less(left,right):
                tail.next = ListNode()
                tail = tail.next
                tail.val=left
                l1=l1.next
            else:
                tail.next = ListNode()
                tail = tail.next
                tail.val=right
                l2=l2.next
            

            
