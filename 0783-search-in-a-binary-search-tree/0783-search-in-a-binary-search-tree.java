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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr =root;
        while(curr!=null){
            if(val==curr.val){
                return curr;
            }
            else if(val< curr.val){
                curr=curr.left;
            }else{
                curr=curr.right;
            }
        }
        return curr;
    }
}