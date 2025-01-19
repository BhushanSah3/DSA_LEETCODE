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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        if(root==null) {
            return result;
        }
        Stack <TreeNode> s =new Stack<>();
        s.push(root);
        
        while(!s.isEmpty()){
            TreeNode current=s.pop();
            result.add(current.val);
            if(current.right!=null){
                s.push(current.right);

            }
            if(current.left!=null){
                s.push(current.left);
            }
            
           
        }
        return result;
    }
}