class Solution {
    public int recur(int i, int j, String text1, String text2, int [][] dp){
        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(text1.charAt(i)==text2.charAt(j)){
            return 1+ recur(i-1, j-1 ,text1, text2, dp);
        }
        return dp[i][j]=0+ Math.max( recur(i, j-1,text1, text2, dp), recur(i-1, j, text1, text2, dp) );


    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n =text1.length();
        int m =text2.length();
        int[][] dp =new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
            
        }
        return recur(n-1,m-1, text1, text2, dp);
        
    }
}