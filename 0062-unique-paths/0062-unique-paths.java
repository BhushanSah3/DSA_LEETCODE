class Solution {
    // public int recur(int i, int j, int[][] dp, int m, int n) {
    //     int count = 0;
    //     if (i == m - 1 && j == n - 1)
    //         return 1;
    //     if (i >= m || j >= n)
    //         return 0;

    //     if (dp[i][j] != -1) {
    //         return dp[i][j];
    //     }

    //     int bottom = recur(i + 1, j, dp, m, n); //0, 0-> 1, 0
    //     int right = recur(i, j + 1, dp, m, n); // 0,0 -> 0,1
    //     count = bottom + right;

    //     return dp[i][j] = count;

    // }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        // return recur(0, 0, dp, m, n);

       dp[m - 1][n - 1] = 1;
   
    for (int i = m - 1; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {
             int right=0, down =0;
            if (i == m - 1 && j == n - 1) continue;
            
            if(i+1<m)  down  =  dp[i + 1][j] ;
            if (j+1<n)  right =  dp[i][j + 1];

            
            dp[i][j] = right + down;
        }
    }

    return dp[0][0]; // Starting point
    
    }

}