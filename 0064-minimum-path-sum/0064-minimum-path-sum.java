class Solution {
    public int recur(int i, int j, int row, int col, int[][] dp,int[][] grid){
        if(i==row-1 && j==col-1) return grid[i][j];
        if(i>=row || j>= col) return Integer.MAX_VALUE;

        if(dp[i][j]!=-1) return dp[i][j];

        int right=  recur(i, j+1, row, col ,dp, grid);
        int down=  recur(i+1, j, row, col, dp,grid);
        dp[i][j] =grid[i][j]+Math.min(right,down);


        return dp[i][j];

    }
    public int minPathSum(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[][] dp =new int[row][col];

        for(int i=0;i<row;i++){
            Arrays.fill(dp[i],-1);
        }

        return recur(0,0,row, col, dp, grid);

        
    }
}