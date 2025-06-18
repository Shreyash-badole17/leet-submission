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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null){
            return head.next;
        }
        // ListNode dummy=new ListNode(0);
        // dummy.next=head;
        // ListNode curr=head;
        // int count=0;
        // while(curr!=null){
        //     curr=curr.next;
        //     count++;
        // }
        // count=(count+1)/2;
        
        // if(count%2==1){
        //     curr=dummy;
        //     for(int i=0;i<count-1;i++){
        //         curr=curr.next;
        //     }
        // }
        // else{
        //     curr=head;
        //     for(int i=0;i<count-1;i++){
        //         curr=curr.next;
        //     }
        // }
        // curr.next=curr.next.next;
        ListNode slow = head, fast = head,prev=null;
        while (fast != null && fast.next != null) {
            prev=slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next=slow.next;
        return head;
    }
}