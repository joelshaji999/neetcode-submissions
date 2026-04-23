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
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        
        max(root);

        return result;
    }
 
    private int max(TreeNode node) {
        if(node == null)
            return 0;

        int leftMax = Math.max(max(node.left), 0);
        int rightMax = Math.max(max(node.right), 0);

        result = Math.max(result, leftMax + rightMax + node.val);
        return node.val + Math.max(leftMax, rightMax);
    }
}
