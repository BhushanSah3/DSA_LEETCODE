class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();
        int l, r;
        int maxlen = 0;
        String ans = "";

        for (int i = 0; i < n; i++) {
            l = i;
            r = i;

            //odd length
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxlen) {
                    maxlen = r - l + 1;
                    ans = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

            //even length
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxlen) {
                    maxlen = r - l + 1;
                    ans = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }
        return ans;
    }
}