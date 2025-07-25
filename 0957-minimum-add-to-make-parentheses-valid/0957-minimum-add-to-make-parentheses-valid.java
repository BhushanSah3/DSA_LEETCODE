class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int open = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    open++;
                }
            }

        }
        return open + st.size();

    }
}