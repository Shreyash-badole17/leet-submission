class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        
        // 1) Split list into [head ... mid) and [mid ... end)
        ListNode mid    = getMid(head);
        ListNode right  = mid.next;
        mid.next        = null;           // cut
        
        // 2) Recursively sort each half
        ListNode leftSorted  = sortList(head);
        ListNode rightSorted = sortList(right);
        
        // 3) Merge the two sorted halves
        return merge(leftSorted, rightSorted);
    }
    
    // Find the node just before the midpoint (slow/fast)
    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next.next;
        // when fast hits end, slow is right before mid
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // Standard merge of two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        // append remaining
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
