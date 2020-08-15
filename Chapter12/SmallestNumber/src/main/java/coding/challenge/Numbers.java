package coding.challenge;
 
import java.util.Stack;

public class Numbers {

    private Numbers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void smallestAfterRemove(String nr, int k) {

        if (nr == null || k <= 0 || k >= nr.length()) {
            System.out.println("The number is: " + 0);
            return;
        }

        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < nr.length()) {
            // if the current digit is less than the previous 
            // digit then discard the previous one
            while (k > 0 && !stack.isEmpty()
                    && stack.peek() > nr.charAt(i)) {
                stack.pop();
                k--;
            }

            stack.push(nr.charAt(i));
            i++;
        }

        // cover corner cases such as '2222'
        while (k > 0) {
            stack.pop();
            k--;
        }

        System.out.println("The number is (as a printed stack; "
                + "ignore leading 0s (if any)): " + stack);
    }
}
