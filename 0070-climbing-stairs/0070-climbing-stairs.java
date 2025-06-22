class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        int left=0, right=0;

        for(int i=2;i<=n;i++){
            left =dp[i-1];
            right=dp[i-2];
            dp[i]=left+right;
        }

       return dp[n];
    }
}