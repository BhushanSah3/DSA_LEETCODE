class Solution {
    public boolean recur(int i, String s, List<String> wordDict, Boolean[] dp) {
        if (i == s.length()) return true;

        if (dp[i] != null) return dp[i];

        for (String word : wordDict) {
            int len = word.length();

            if (i + len <= s.length() && s.substring(i, i + len).equals(word)) {
                if (recur(i + len, s, wordDict, dp)) {
                    return dp[i] = true;
                }
            }
        }

        return dp[i] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return recur(0, s, wordDict, dp);
        
    }
}
