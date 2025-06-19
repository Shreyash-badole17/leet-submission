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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currA=l1,currB=l2;
        ListNode dummy=new ListNode(0);
        ListNode l3=dummy;
        int carry=0;
        while(currA!=null||currB!=null||carry!=0){
            int a=(currA!=null?currA.val:0);
            int b=(currB!=null?currB.val:0);
            int sum=a+b+carry;
            int actualVal=sum%10;

            l3.next= new ListNode(actualVal);
            l3=l3.next;

            carry=sum/10;

            if(currA!=null)currA=currA.next;
            if(currB!=null)currB=currB.next;
        }
        return dummy.next;
    }
}