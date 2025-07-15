class Solution {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int profit = 0;
        int cp = Integer.MAX_VALUE;
        // for (int i = 0; i < prices.length; i++) {
        //     if (prices[i] < cp) {
        //         cp = prices[i];
        //     } else {
        //         profit = prices[i] - cp;
        //     }
        //     if (profit > maxProfit) {
        //         maxProfit = profit;
        //     }
        // }
       // return maxProfit;

       int mincost=prices[0];
       for(int i=1;i<prices.length;i++){
        int cost=prices[i]-mincost;
        profit=Math.max(profit, cost);
        mincost=Math.min(mincost, prices[i]);
       }
       return profit;
    }
}
