/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public TreeNode answerNode;

    public boolean dfs(TreeNode curr, TreeNode p, TreeNode q) {
        if (curr == null) {
            return false;
        }
        if (curr == p || curr == q) { // 2번 경우
            answerNode = curr;
            return true;
        }

        boolean isOk1 =  dfs(curr.left, p, q);
        boolean isOk2 =  dfs(curr.right, p, q);

        if (isOk1 && isOk2) { // 1번 경우
            answerNode = curr;
        }

        return isOk1 || isOk2; // 하나라도 대상 노드가 포함된 경우
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // 최소 공통 조상 (Lowest Common Ancestor)
        // 총 2가지 경우가 존재한다고 생각함, 아래와 같음
        // 1. 현재 자식노드 A,B가 p, q와 같아, 현재 노드가 LCA 되는 경우
        // 2. p 또는 q가 서로 포함하는 경우 = 포함하는 노드가 LCA 임
        dfs(root, p, q);
        return answerNode;
    }
}