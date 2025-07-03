class Solution {
    public int recur(int i, int j, int row, int col, int[][] dp, int[][] grid) {
        if (i == row - 1 && j == col - 1)
            return grid[i][j];
        if (i >= row || j >= col)
            return Integer.MAX_VALUE;

        if (dp[i][j] != -1)
            return dp[i][j];

        int right = recur(i, j + 1, row, col, dp, grid);
        int down = recur(i + 1, j, row, col, dp, grid);
        dp[i][j] = grid[i][j] + Math.min(right, down);

        return dp[i][j];

    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        //return recur(0,0,m, n, dp, grid);

       dp[0][0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
              
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m-1][n-1]; 

    }
}