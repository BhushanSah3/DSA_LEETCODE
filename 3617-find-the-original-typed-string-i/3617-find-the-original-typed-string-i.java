class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int result = 1; 
        int i = 0;
        
        while (i < n) {
            int count = 1;
            while (i + 1 < n && word.charAt(i) == word.charAt(i + 1)) {
                count++;
                i++;
            }
            result += count - 1;
            i++;
        }

        return result;
    }
}
