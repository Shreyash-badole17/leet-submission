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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root==null){
            return ls;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            ls.add(curr.val);
            if(curr.right!=null){
                st.push(curr.right);
            }
            if(curr.left!=null){
                st.push(curr.left);
            }
        }
        return ls;
    }
}

//-- Recursive solution--
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> ls= new ArrayList<>();
//         traverse(root,ls);
//         return ls;
//     }
//     private void traverse(TreeNode root, List<Integer> ls){
//         if(root==null) return;
//         ls.add(root.val);
//         traverse(root.left,ls);
//         traverse(root.right,ls);
//     }
// }