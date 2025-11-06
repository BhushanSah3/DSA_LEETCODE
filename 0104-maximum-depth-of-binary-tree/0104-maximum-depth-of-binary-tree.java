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
        if(root==null){
            return 0;
        }
        int level =0;
        Queue<TreeNode> q=new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()){
            int qsize=q.size();

            for(int i=0;i<qsize;i++){
                TreeNode front= q.poll();
                if(front.right!=null){
                    q.add(front.right);
                }
                if(front.left!=null){
                    q.add(front.left);
                }

            }
            level++;
        }
        return level;
    }
}