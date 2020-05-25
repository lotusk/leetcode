# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        p1 = head
        p2 = head
        # p1index =0
        p2index =0
        
        while True:
            # print(p2.val)
            if p2index >n:
                p1=p1.next
                # p1index =p1index++
            if p2.next:
                p2index= p2index+1
                p2 = p2.next
            else:
                break
        if p2index < n:
            return head.next
        # elif n==1:
        #     p1.next=None
        else :        
            p1.next = p1.next.next
        return head
            
            
        
