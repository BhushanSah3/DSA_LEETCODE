class Solution {
    public int recur(int i, int per, int cap, int[] prices, int[][][] dp) {
        if (i == prices.length)
            return 0;
        if (cap == 0)
            return 0;

        if (dp[i][per][cap] != -1)
            return dp[i][per][cap];

        if (per == 1) {
            dp[i][per][cap] = Math.max(-prices[i] + recur(i + 1, 0, cap, prices, dp),
                    0 + recur(i + 1, 1, cap, prices, dp));

        } else {
            dp[i][per][cap] = Math.max(prices[i] + recur(i + 1, 1, cap - 1, prices, dp),
                    0 + recur(i + 1, 0, cap, prices, dp));

        }
        return dp[i][per][cap];

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n+1][2][3];

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<2;j++){
        //         Arrays.fill(dp[i][j],-1);

        //     }

        // }
        //return recur(0,1, 2, prices, dp);

        //cap==0
        for (int i = 0; i < n - 1; i++) {
            for (int per = 0; per <= 1; per++) {
                dp[i][per][0] = 0;
            }
        }

        // index=n
        for (int per = 0; per <= 1; per++) {
            for (int cap = 0; cap <= 2; cap++) {
                dp[n][per][cap] = 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int per = 0; per <= 1; per++) {
                for (int cap = 1; cap <= 2; cap++) { // base case have wriiten for cap ==0 so start from 1
                    if (per == 1) {
                        dp[i][per][cap] = Math.max( -prices[i] + dp[i + 1][0][cap], 0 + dp[i + 1][1][cap]);

                    } else {
                        dp[i][per][cap] = Math.max( prices[i] + dp[i + 1][1][cap - 1], 0 + dp[i + 1][0][cap]);

                    }

                }
            }
        }
        return dp[0][1][2];

    }
}