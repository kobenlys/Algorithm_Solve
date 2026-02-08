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

    public void dfs(TreeNode curr) {

        if(curr == null) {
            return;
        }

        dfs(curr.left);
        dfs(curr.right);
        TreeNode tmp = curr.right;
        curr.right = curr.left;
        curr.left = tmp;
    }

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
}