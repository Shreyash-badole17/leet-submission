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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        if(lists!=null){
            for(int i=0;i<lists.length;i++){
                ListNode temp = lists[i];
                while(temp!=null){
                    minHeap.offer(temp.val);
                    temp=temp.next;
                }
            }
        }
        ListNode dummy= new ListNode(0);
        ListNode curr=dummy;
        
        while(!minHeap.isEmpty()){
            ListNode tmp = new ListNode(minHeap.poll());
            curr.next= tmp;
            curr = curr.next;
        }
        return dummy.next;
    }
}