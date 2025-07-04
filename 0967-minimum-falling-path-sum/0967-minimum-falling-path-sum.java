class Solution {
    public int recur(int i, int j, int m, int[][] dp, int [][] matrix){
        if (j < 0 || j >= m) return Integer.MAX_VALUE; 
        if (i == m - 1) return matrix[i][j];

        if(dp[i][j]!=-1) return dp[i][j];
       
        int leftdiag = recur(i + 1, j - 1, m, dp, matrix);
        int rightdiag = recur(i + 1, j + 1, m, dp, matrix);
        int down = recur(i + 1, j, m, dp, matrix);
        dp[i][j] = matrix[i][j] + Math.min(leftdiag, Math.min(rightdiag, down));


        return dp[i][j];


    }

    public int minFallingPathSum(int[][] matrix) {
      
        int m=matrix.length;
        int [][] dp =new int[m][m];
        int a=Integer.MAX_VALUE;   ////////////////

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        
        // for(int i=0;i<m;i++){
        //      a = Math.min(a, recur(0, i, m, dp, matrix));
        // }

        // return a;

        //tabulation
        for (int j = 0; j < m; j++) {
            dp[m - 1][j] = matrix[m - 1][j];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                int down = dp[i + 1][j];
                int leftDiag = (j - 1 >= 0) ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
                int rightDiag = (j + 1 < m) ? dp[i + 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(leftDiag, rightDiag));
            }
        }
    
        for (int j = 0; j < m; j++) {
            a = Math.min(a, dp[0][j]);
        }
 
        return a;
        
        

        
    }
}