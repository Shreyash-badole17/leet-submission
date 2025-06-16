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
    public ListNode middleNode(ListNode head) {
        ListNode curr=head;
        ListNode middle=head;
        int count=0;
        while(curr!=null){
            count++;
            if(count%2==0){
                middle=middle.next;
                curr=curr.next;
            }
            else{
                curr=curr.next;
            }
        }
        return middle;
    }
}