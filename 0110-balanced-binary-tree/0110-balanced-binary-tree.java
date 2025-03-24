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
    // Helper method to check balance and calculate height
    private boolean bhushan(TreeNode root, int[] height) {
        if (root == null) {
            height[0] = 0; // Empty tree has height 0
            return true;   // Base case: Empty tree is balanced
        }

        // Arrays to store left and right subtree heights
        int[] leftHeight = new int[1];
        int[] rightHeight = new int[1];

        // Recursively check left and right subtrees
        boolean leftBalanced = bhushan(root.left, leftHeight);
        boolean rightBalanced = bhushan(root.right, rightHeight);

        // Update current node's height
        height[0] = Math.max(leftHeight[0], rightHeight[0]) + 1;

        // Check balance condition: Difference should not exceed 1
        if (Math.abs(leftHeight[0] - rightHeight[0]) > 1) {
            return false; // Unbalanced if height difference > 1
        }

        // Return true if both subtrees are balanced
        return leftBalanced && rightBalanced;
    }

    public boolean isBalanced(TreeNode root) {
        int[] height = new int[1]; // Use an array to pass height by reference
        return bhushan(root, height);
    }
}
