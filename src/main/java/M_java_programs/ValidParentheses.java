package M_java_programs;


import java.util.Stack;

/*Example:
        "()[]{}" → true
        "(]" → false
        "([{}])" → true
        "((())" → false */
public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }

            }

        }

        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([{}])"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("((())"));
    }
}
