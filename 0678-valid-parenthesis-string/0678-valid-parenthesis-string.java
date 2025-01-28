class Solution {
    public boolean checkValidString(String s) {
        int max = 0;
        int min = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                min++;
                max++;
            }
            else if(s.charAt(i) == ')') {
                min--;
                max--;
            }
            else if(s.charAt(i) == '*') {
                min--; // * could be )
                max++; // * could be (
            }
            
            if(max < 0) return false;  // too many )
            min = Math.max(0, min);    // can't have negative open brackets
        }
        
        return min <= 0 && max >= 0;  // can we have valid number of open brackets?
    }
}