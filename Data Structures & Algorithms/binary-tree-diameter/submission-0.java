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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxDiameter;
    }

    public int helper(TreeNode node) {
        if(node == null) {
            return 0;
        } else {
            int left = helper(node.left);
            int right = helper(node.right);
            if(left + right > maxDiameter) {
                maxDiameter = left + right;
            }
            return (left > right ? left : right) + 1;
        }
    }
}
