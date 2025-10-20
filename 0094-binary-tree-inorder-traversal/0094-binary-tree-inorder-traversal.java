/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root==null){
            return ls;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr =root;
        while(curr!=null||!st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }                        
            curr=st.pop();
            ls.add(curr.val);
            
            curr=curr.right;
        }
        return ls;
    }
}

// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> ls = new ArrayList<>();
//         traverse(root,ls);
//         return ls;
//     }
//     private void traverse(TreeNode root,List<Integer> ls){
//         if(root==null) return;
//         traverse(root.left,ls);
//         ls.add(root.val);
//         traverse(root.right,ls);
//     }
// }