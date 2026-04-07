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
    public TreeNode invertTree(TreeNode root) {
        return invertTreeHelper(root);
    }

    public TreeNode invertTreeHelper(TreeNode node) {
        if(node == null) {
            return null;
        } else {
            TreeNode temp = invertTreeHelper(node.left);
            node.left = invertTreeHelper(node.right);
            node.right = temp;
            return node;
        }
    }
}
