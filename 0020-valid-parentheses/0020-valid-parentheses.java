class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack1 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack1.push(s.charAt(i));
            } else {
                if (stack1.isEmpty()) {
                    return false;
                }
                char ch = stack1.pop();
                if ((s.charAt(i) == ')' && ch != '(') ||
                        (s.charAt(i) == '}' && ch != '{') ||
                        (s.charAt(i) == ']' && ch != '[')) {
                    return false;
                }

            }

        }
        return stack1.isEmpty(); // if the stack is empty which is true then the boolean function will al;so
                                 // return true

    }
}