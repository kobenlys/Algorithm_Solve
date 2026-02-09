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

    public boolean isBalanced;

    public int dfs(TreeNode curr) {

        if(curr == null || !isBalanced) {
            return 1;
        }

        int depthLeft = dfs(curr.left);
        int depthRight = dfs(curr.right);

        if(Math.abs(depthLeft - depthRight) > 1) {
            isBalanced = false;
        }

        return Math.max(depthLeft, depthRight) + 1 ;
    }

    public boolean isBalanced(TreeNode root) {

        if(root == null) {
            return true;
        }
        isBalanced = true;
        dfs(root);

        return isBalanced;
    }
}