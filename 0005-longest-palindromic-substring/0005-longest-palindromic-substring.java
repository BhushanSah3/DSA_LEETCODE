class Solution {
    public boolean ispalindrome(String key) {
        int l = 0;
        int r = key.length()-1;
        while (l < r) {
            if (key.charAt(l) != key.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;

    }

    public String longestPalindrome(String s) {
        
        int n = s.length();
        if(n==1){
            return s;
        }
        int maxlen = 0;
        String key;
        String ans = "";

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n ; j++) {
                key = s.substring(i, j + 1);

                if (ispalindrome(key)) {
                    int len = key.length();
                    if (len > maxlen) {
                        maxlen = len;
                        ans = key;
                    }

                }

            }
        }
        return ans;

    }
}