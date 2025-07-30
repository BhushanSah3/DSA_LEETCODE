class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[][] dp = new long[n + 1][n + 1];
          
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int stops = 0; stops <= n; stops++) {
            long dist = recur(n, stops, startFuel, stations, dp);
            if (dist >= target) {
                return stops;
            }
        }

        return -1;
    }

    private long recur(int i, int stops, int startFuel, int[][] stations, long[][] dp) {
        if (stops < 0) {
            return Long.MIN_VALUE;
        }

        if (i == 0) {
            if(stops == 0) return startFuel;
            return Long.MIN_VALUE;
        }

        if (dp[i][stops] != -1) {
            return dp[i][stops];
        }

        long nottake = recur(i - 1, stops, startFuel, stations, dp);

        long take = Long.MIN_VALUE;
        long reachbefore = recur(i - 1, stops - 1, startFuel, stations, dp);
        
        if (reachbefore >= stations[i - 1][0]) {
            take = reachbefore + stations[i - 1][1];
        }

        return dp[i][stops] = Math.max(take, nottake);
    }
}