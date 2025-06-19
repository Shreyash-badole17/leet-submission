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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode start = head, end = head;
        int length=1;
        while (end.next != null) {
            end = end.next;
            length++;
        }
        k%=length;
        if(k==0){
            return head;
        }
        end.next=head;
        for(int i=0;i<length-k;i++){
            end=end.next;
        }
        ListNode newhead=end.next;
        end.next=null;

        return newhead;
    }
}