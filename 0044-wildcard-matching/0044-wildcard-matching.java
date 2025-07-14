class Solution {
    public boolean recur(int i, int j, String s, String p, Boolean[][] dp){
        if(i<0 && j<0) return true;
        if (i >= 0 && j < 0) return false;

        if (i < 0 && j >= 0) {
            for(int check=0;check<=j;check++){
                if(p.charAt(check)!='*'){
                    return false;
                }
            }
            return true;

        }
        

        if(dp[i][j] !=null) return dp[i][j];

        if(s.charAt(i)== p.charAt(j) || p.charAt(j)=='?'){
            return dp[i][j]= recur(i-1, j-1, s,p, dp);
        }else if(p.charAt(j)=='*'){
            return dp[i][j]= recur(i-1, j, s,p, dp) || recur(i, j-1, s,p, dp);
        }
        else{
            return dp[i][j]= false;
        }
    }
    public boolean isMatch(String s, String p) {
        int n=s.length(), m=p.length();
        Boolean [][] dp =new Boolean [n+1][m+1];
        // herer notice i used Boolean instead of boolean  and omitted initialization of -1 
        
        return recur(n-1, m-1, s, p, dp);
    }
}