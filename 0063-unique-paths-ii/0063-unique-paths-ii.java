class Solution {
    public int recur(int i, int j, int[][] dp, int row, int col, int[][] obstacleGrid) {
        int result = 0;

        if (i >= row || j >= col)
            return 0;
        if (obstacleGrid[i][j] == 1 && (i == row - 1 && j == col - 1))
            return 0;
        if (i == row - 1 && j == col - 1)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (obstacleGrid[i][j] == 1)
            return 0;

        int right = recur(i, j + 1, dp, row, col, obstacleGrid);
        int bottom = recur(i + 1, j, dp, row, col, obstacleGrid);

        result = bottom + right;
        return dp[i][j] = result;

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        // return recur(0,0, dp, m, n,obstacleGrid);

        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int down =0, right=0;
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // 0 ways to reach the destination from an obstacle cell
                    continue;
                }

                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = 1; // base case
                } else {
                    if(i+1<m)   down = dp[i + 1][j];
                    if(j+1<n)   right = dp[i][j + 1];

                    dp[i][j] = down + right;
                }
            }
        }

        return dp[0][0];

    }

}