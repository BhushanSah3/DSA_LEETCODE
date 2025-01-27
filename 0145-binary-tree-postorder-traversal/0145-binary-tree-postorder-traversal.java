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
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode curr = root;
        Stack<TreeNode> s = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode temp;
        while (curr != null || !s.isEmpty()) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                temp = s.peek().right;
                if (temp == null) {
                     temp = s.peek();
                    s.pop();
                    res.add(temp.val);

                    while (!s.isEmpty() && temp == s.peek().right) {
                        temp = s.peek();
                        s.pop();
                        res.add(temp.val);
                    }
                } else {
                    curr = temp;
                }

            }
        }
        return res;
    }
}