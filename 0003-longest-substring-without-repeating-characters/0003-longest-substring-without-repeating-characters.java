class Solution {
    public int lengthOfLongestSubstring(String s) {
         int[] lastSeen = new int[256]; 
        Arrays.fill(lastSeen, -1);

        int left = 0, len = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (lastSeen[c] != -1) {
                left = Math.max(left, lastSeen[c] + 1);
            }

            lastSeen[c] = right;
            len = Math.max(len, right - left + 1);
        }

        return len;
    }
}