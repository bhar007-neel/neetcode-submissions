

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // If opening bracket, push it
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            // Otherwise, it must be a closing bracket
            else {

                // Nothing available to match with
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Check if brackets match
                if (c == ')' && top != '(') {
                    return false;
                }

                if (c == '}' && top != '{') {
                    return false;
                }

                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }

        // If stack is empty, every bracket was matched
        return stack.isEmpty();
    }
}