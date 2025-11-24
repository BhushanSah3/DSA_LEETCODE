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
    public int kthSmallest(TreeNode root, int k) {
        int count=0;
        Stack<TreeNode> s=new Stack<>();
        TreeNode curr=root;
        s.push(curr);
        int ans=0;

        while( curr!=null || !s.isEmpty()){
            while(curr!=null){
                s.push(curr);
                curr=curr.left;

            }
            curr= s.pop();

            count++;
            ans=curr.val;
            if(count==k) return ans;
            curr=curr.right;


        }
        return ans;

        
    }
}