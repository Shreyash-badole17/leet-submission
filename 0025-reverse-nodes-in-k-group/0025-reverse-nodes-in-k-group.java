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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy, end = dummy, curr = dummy, newhead = dummy;

        while (true) {
            end = newhead;
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;

            start = newhead.next;
            curr = end.next;

            reverse(start, end);

            newhead.next = end;
            start.next = curr;

            newhead = start;
        }

        return dummy.next;
    }

    private void reverse(ListNode start, ListNode end) {
        ListNode prev = end.next;
        ListNode curr = start;
        while (prev != end) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
    }
}
