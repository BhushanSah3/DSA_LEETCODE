class Solution {
    public int func(int n, int[] dp) {
        if (n == 0 || n == 1) return 1;

        if (dp[n]!= -1) return dp[n];

        int left = func(n - 1, dp);
        int right = func(n - 2, dp);

        dp[n] = left + right;
        return dp[n];

    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return func(n, dp);

    }
}