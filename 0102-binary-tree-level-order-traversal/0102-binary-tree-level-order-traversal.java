/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return result;
        }
        q.offer(root);  // hum pehle root ko push kar rahe haii

        while (!q.isEmpty()) { 
            int levelsize = q.size();  // this means that hum kitne no k liye uske left child or right child ko dhuddenge
            List<Integer> result2 = new ArrayList<>();

            for (int i = 0; i < levelsize; i++) {
            // this loop just checks that hum levelsize k liye check kar rahe haii na 
                TreeNode current = q.poll(); // for the same root , queue se nikalke levelsize bhi kaam kardiya 
                result2.add(current.val); // added in the result ds

                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }
            result.add(result2);
            
        }
        return result;
    }
}