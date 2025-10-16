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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        traverse(root,0,ls);
        return ls;
    }
    private void traverse(TreeNode root,int level,List<List<Integer>> ls){
        if(root==null)
        return;

        if(ls.size()<=level){
            ls.add(new ArrayList<>());
        }

        ls.get(level).add(root.val);

        traverse(root.left,level+1,ls);
        traverse(root.right,level+1,ls);
    }
}