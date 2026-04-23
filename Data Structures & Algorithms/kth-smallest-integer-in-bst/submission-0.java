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
    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        nodeToList(root);

        System.out.println(list);
        return list.get(k-1);
    }

    private void nodeToList(TreeNode node) {
        if(node == null)
            return;
        
        nodeToList(node.left);
        list.add(node.val);
        nodeToList(node.right);

    }
}
