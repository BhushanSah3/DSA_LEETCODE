class Solution {
    public int findpath(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        // if (i == triangle.size() || j == triangle.size())
        //     return 0;
        if (i == triangle.size())
            return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int leftside = findpath(i + 1, j, triangle, dp);
        int rightside = findpath(i + 1, j + 1, triangle, dp);

        dp[i][j] = triangle.get(i).get(j) + Math.min(leftside, rightside);
        return dp[i][j];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        // return findpath(0, 0, triangle,dp);

        //TABULATION FROM HERE 
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j)
                        + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);

            }
        }
        return dp[0][0];

    }
}