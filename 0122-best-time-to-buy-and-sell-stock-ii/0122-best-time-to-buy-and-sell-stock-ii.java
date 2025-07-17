class Solution {
    public int recur(int i, int per, int[] prices, int[][] dp) {
        if (i == prices.length)
            return 0;

        if (dp[i][per] != -1)
            return dp[i][per];

        if (per == 1) {
            dp[i][per] = Math.max((-prices[i] + recur(i + 1, 0, prices, dp)), (0 + recur(i + 1, 1, prices, dp)));
        } else {
            dp[i][per] = Math.max((prices[i] + recur(i + 1, 1, prices, dp)), (0 + recur(i + 1, 0, prices, dp)));
        }
        return dp[i][per];

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2 + 1];

        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return recur(0,1, prices,dp);

        dp[n][0] = 0;
        dp[n][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int per = 0; per <= 1; per++) {
                if (per == 1) {
                    dp[i][per] = Math.max((-prices[i] + dp[i+1][0]),
                            (0 + dp[i+1][1]));
                } else {
                    dp[i][per] = Math.max((prices[i] + dp[i + 1][1]), (0 + dp[i+1][0]) );
                }
            }
        }

        return dp[0][1];

    }
}