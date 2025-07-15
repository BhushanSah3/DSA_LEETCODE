class Solution {
    public boolean recur(int i, int j, String s, String p, Boolean[][] dp) {
        if (i < 0 && j < 0)
            return true;
        if (i >= 0 && j < 0)
            return false;

        if (i < 0 && j >= 0) {
            for (int check = 0; check <= j; check++) {
                if (p.charAt(check) != '*') {
                    return false;
                }
            }
            return true;

        }

        if (dp[i][j] != null)
            return dp[i][j];

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j] = recur(i - 1, j - 1, s, p, dp);
        } else if (p.charAt(j) == '*') {
            return dp[i][j] = recur(i - 1, j, s, p, dp) || recur(i, j - 1, s, p, dp);
        } else {
            return dp[i][j] = false;
        }
    }

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        Boolean[][] dp = new Boolean[n + 1][m + 1];
        boolean[][] dp1 = new boolean[n + 1][m + 1];
        // herer notice i used Boolean instead of boolean  and omitted initialization of -1 

        //return recur(n-1, m-1, s, p, dp);

        dp1[0][0] = true;

        for (int i = 1; i <= n; i++) {
            dp1[i][0] = false;
        }

        // for (int j = 1; j <= m; j++) {
        //     for (int check = 1; check <= j; check++) {
        //         if (p.charAt(check-1) != '*') {
        //             dp1[0][j]= false;
        //         }
        //     }
        //     dp1[0][j]= true;
        // }
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp1[0][j] = dp1[0][j - 1];
            } else {
                dp1[0][j] = false;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp1[i][j] = dp1[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp1[i][j] = dp1[i - 1][j] || dp1[i][j - 1];
                } else {
                    dp1[i][j] = false;
                }
            }
        }
        return dp1[n][m];
    }
}