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
    public int maxDepth(TreeNode root) {
        return maxDepthHelper(root, 0);
    }

    public int maxDepthHelper(TreeNode node, int count) {
        if(node == null) {
            return count;
        } else {
            int left = maxDepthHelper(node.left, count + 1);
            int right = maxDepthHelper(node.right, count + 1);
            return left > right ? left : right;
        }
    }
}
