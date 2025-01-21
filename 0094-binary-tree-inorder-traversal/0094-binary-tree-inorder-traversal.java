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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack <TreeNode > s =new Stack<>();
        List <Integer> result =new ArrayList<>();
        if(root==null){
            return result;
        } 
        TreeNode current=root;
        while(current != null || !s.isEmpty()){ 
            // 
            while(current!=null){
                s.push(current);
                current=current.left;
            }
            current=s.pop();
            result.add(current.val);
            current=current.right;
           
        }
        return result;
    }
}