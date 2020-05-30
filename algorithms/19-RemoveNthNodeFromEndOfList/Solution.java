/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        int p2index =0;
        while (true){
            if (p2index >n){
                p1=p1.next;
            }
            if (p2.next!=null){
                p2index = p2index+1;
                p2 = p2.next;
            }else{
                break;
            }
            
        }
        if (p2index < n)
            return head.next;
        
        else{
            p1.next = p1.next.next;
        }      
            
        return head;   
            
    }
}
