class Solution {
    public int recur(int i,int j, int[][] dp, int row, int col,int[][] obstacleGrid){
        int result=0;

        if(i>=row || j>=col) return 0;
        if(obstacleGrid[i][j]==1 && (i==row-1 && j==col-1 )) return 0;
        if(i==row-1 && j==col-1) return 1;

        if(dp[i][j]!=-1) return dp[i][j];

        if(obstacleGrid[i][j]==1) return 0;

        int right= recur(i, j+1,dp, row, col,obstacleGrid);
        int bottom=recur(i+1,j, dp, row, col,obstacleGrid);

        result= bottom+right;
         return dp[i][j]=result;

        

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;

        int[][] dp =new int[row][col];
        for (int i = 0; i < row; i++) {
           Arrays.fill(dp[i], -1);
        }

        return recur(0,0, dp, row, col,obstacleGrid);
    }
}