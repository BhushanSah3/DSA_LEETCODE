class Solution {
    public int recur(int i, int amount, int[] coins, int[][] dp) {

        if (amount == 0)
            return 1;
        if (i == coins.length)
            return 0;

        if (dp[i][amount] != -1)
            return dp[i][amount];

        int take = 0;
        int nottake = recur(i + 1, amount, coins, dp);

        if (coins[i] <= amount) {
            take = recur(i, amount - coins[i], coins, dp);
        }

        return dp[i][amount] = take + nottake;

    }

    public int change(int amount, int[] coins) {
        int n=coins.length;
        int [][] dp =new int [n+1][amount+1];
        
        // for(int i=0;i<=n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        //return recur(0,amount, coins, dp);

        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }

        for(int i=n-1;i>=0;i--){
            for(int t=0;t<=amount;t++){
                int take=0;
                int nottake=dp[i+1][t];

                if(coins[i]<=t){
                    take=dp[i][t-coins[i]];
                }

                dp[i][t]= take + nottake;

            }
        }
        return dp[0][amount];




        
    }
}