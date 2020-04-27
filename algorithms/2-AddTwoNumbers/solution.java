/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode resultTail=result;
        int carry= 0;
            
        while (l1 !=null ||  l2!=null || carry ==1){
            // System.out.println(l1.val);
            int l1val=l1!=null ? l1.val : 0;
            int l2val=l2!=null ? l2.val : 0;
            int sum = l1val +l2val +carry;
            
            carry= sum >=10 ? 1: 0;
            int tval=sum % 10 ;
            // System.out.println("carry:"+carry);
            resultTail.next = new ListNode(tval);
            resultTail = resultTail.next;
            l1=l1 !=null ? l1.next : null;
            l2=l2!=null ? l2.next : null;          
        }
        return result.next;
    }
}
