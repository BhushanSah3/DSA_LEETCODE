class Solution {
    public int recur(int i, int j, String s, String t, int[][] dp){
        
        if(j<0) return 1;
        if(i<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]= recur(i-1, j-1, s,t,dp) + recur(i-1, j, s,t, dp);
        }
        else{
           return dp[i][j]= recur(i-1, j, s, t, dp);
        }
       
    }
    public int numDistinct(String s, String t) {
        int n=s.length(), m=t.length();
        int[][] dp=new int[n+1][m+1];

        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }

       //return recur(n-1, m-1,s, t, dp);

       for(int i=0;i<=n;i++){
        dp[i][0]=1;
       }
       for(int i=1;i<=m;i++){
        dp[0][i]=0;    // this is base case but by default it is initialized by 0 
       }

       for(int i=1;i<=n;i++){
         for(int j=1;j<=m;j++){
            if(s.charAt(i-1)==t.charAt(j-1)){
             dp[i][j]= dp[i-1][j-1] + dp[i-1][j];
             }
            else{
                dp[i][j]= dp[i-1][j];
            }
        }
       }
       return dp[n][m];

        
    }
}