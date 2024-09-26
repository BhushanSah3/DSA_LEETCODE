class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        
        HashMap<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int len = 0;
            hash.clear();
            for (int j = i; j < s.length(); j++) {
                if (hash.containsKey(s.charAt(j))) {
                    break;
                }
                hash.put(s.charAt(j), 1);
                len++;
                max = Math.max(max, len);

            }
        }
        return max;
    }
}