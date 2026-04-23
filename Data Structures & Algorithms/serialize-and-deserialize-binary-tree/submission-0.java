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

public class Codec {
    String s = "";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            s = s + "null,";
            return s;
        }

        s = s + root.val + ",";

        serialize(root.left);
        serialize(root.right);


        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        String[] cArr = data.split(",");
        int[] i = new int[] {0};
        return createTree(cArr, i);
    }

    private TreeNode createTree(String[] cArr, int[] i) {
        System.out.println("i" + i[0]);

        if(cArr[i[0]].equals("null")) {
            i[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(cArr[i[0]]));
        i[0]++;
        node.left = createTree(cArr, i);
        node.right = createTree(cArr, i);
        
        return node;
    }
}
