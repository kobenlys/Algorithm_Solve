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

    public int max = 0;
    public TreeNode maxNode = null;

    public int dfs(TreeNode curr) {
        if(curr == null) {
            return 0;
        }

        int leftStep = dfs(curr.left) + 1;
        int rightStep = dfs(curr.right) + 1;
        max = Math.max(max, leftStep + rightStep);
        return Math.max(leftStep, rightStep);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max - 2;
    }
}