class Solution {
    public int recur(int i, int j, String word1, String word2, int[][] dp){
         if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=-1) return dp[i][j];

        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]= recur(i-1,j-1, word1, word2, dp);
        }else{
           return dp[i][j]= Math.min( 1+ recur(i,j-1, word1, word2, dp)  //insert 
            , Math.min(
            1+ recur(i-1,j, word1, word2, dp), //remove 
            1+ recur(i-1,j-1, word1, word2, dp) )
            ); // replace 
        }
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length(), m=word2.length();

        int [][] dp =new int[n+1][m+1];

        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return recur(n-1, m-1, word1, word2, dp);

        for(int i=0;i<=n;i++){
            dp[i][0]=i ;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=j ;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                     dp[i][j]= dp[i-1][j-1];
                }else{
                     dp[i][j]= Math.min( (1+ dp[i][j-1])  , Math.min( (1+dp[i-1][j]) ,( 1+ dp[i-1][j-1] )) );
                }
            }
        }

        return dp[n][m];



        
    }
}