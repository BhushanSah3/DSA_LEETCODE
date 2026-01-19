class Solution {
    int inf = 1000000007;

    public int recur(int[] coins, int idx, int amount, int[][] dp) {
        if (idx == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            } else {
                return inf;
            }
        }

        if (dp[idx][amount] != -1) {
            return dp[idx][amount];
        }

        int nottake = 0 + recur(coins, idx - 1, amount, dp);
        int take = inf;

        if (coins[idx] <= amount) {
            take = 1 + recur(coins, idx, amount - coins[idx], dp);
        }

        return dp[idx][amount] = Math.min(take, nottake);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // int ans= recur(coins,coins.length-1, amount,dp);
        // return ans >= inf ? -1 : ans;

        //TABULATION STARTS HERE

        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) {
                dp[0][t] = t / coins[0];
            } else {
                dp[0][t]=inf;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= amount; t++) {
                int nottake = 0 + dp[i - 1][t];
                int take = inf;

                if (coins[i] <= t) {
                    take = 1 + dp[i][t-coins[i]];
                }
                dp[i][t]=Math.min(take, nottake);
            }
        }
        int ans= dp[n-1][amount];
        return ans >= inf ? -1 : ans;
    }
}