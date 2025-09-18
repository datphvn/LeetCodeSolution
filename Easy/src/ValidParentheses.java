import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);

            }
            else{
                if(stack.isEmpty()){ return false; }
                char top = stack.pop();
                if((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses checker = new ValidParentheses();

        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([])";
        String s5 = "([)]";

        System.out.println(s1 + " -> " + checker.isValid(s1)); // true
        System.out.println(s2 + " -> " + checker.isValid(s2)); // true
        System.out.println(s3 + " -> " + checker.isValid(s3)); // false
        System.out.println(s4 + " -> " + checker.isValid(s4)); // true
        System.out.println(s5 + " -> " + checker.isValid(s5)); // false
    }
}
