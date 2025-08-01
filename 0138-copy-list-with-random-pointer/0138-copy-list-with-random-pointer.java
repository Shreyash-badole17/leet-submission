/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Map<Node,Node> map= new HashMap<>();
        Node cur= head;
        while(cur!=null){
            map.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        while(cur!=null){
            Node now=map.get(cur);
            now.next=map.get(cur.next);
            now.random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }
}