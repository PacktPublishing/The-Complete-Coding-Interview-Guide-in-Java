package coding.challenge;

import java.util.Stack;

public final class Stacks {

    private Stacks() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String reverse(String str) {
                
        Stack<Character> stack = new Stack();

        // push characters of the string into the stack
        char[] chars = str.toCharArray();
        for (char c : chars) {
            stack.push(c);
        }

        // pop all characters from the stack and
        // put them back to the input string
        for (int i = 0; i < str.length(); i++) {
            chars[i] = stack.pop();
        }

        // return the string
        return new String(chars);
    }
}
