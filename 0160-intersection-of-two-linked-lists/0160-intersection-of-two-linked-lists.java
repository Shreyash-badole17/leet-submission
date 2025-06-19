/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1=headA,l2=headB;
        int lengthA=0,lengthB=0;
        while(l1!=null){
            l1=l1.next;
            lengthA++;
        }
        while(l2!=null){
            l2=l2.next;
            lengthB++;
        }
        // if(lengthA==1){
        //     if(headA==headB)
        //     return headA;
        // }
        // if(lengthB==1){
        //     if(headA==headB)
        //     return headB;
        // }
        if(lengthA>=lengthB){
            int length=lengthA-lengthB;
            l1=headA;
            l2=headB;
            while(length>0){
                length--;
                l1=l1.next;
            }
            while(l1!=null){
                if(l1!=l2){
                    l1=l1.next;
                    l2=l2.next;
                }
                else{
                    return l1;
                }
            }
        }
        else{
            int length=lengthB-lengthA;
            l1=headA;
            l2=headB;
            while(length>0){
                length--;
                l2=l2.next;
            }
            while(l2!=null){
                if(l1!=l2){
                    l1=l1.next;
                    l2=l2.next;
                }
                else{
                    return l2;
                }
            }
        }
        return null;
    }
}