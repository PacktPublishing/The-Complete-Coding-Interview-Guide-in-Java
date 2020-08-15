package coding.challenge;
 
import java.util.EmptyStackException;
import java.util.Stack;

public class MyStack {

    private int min;
    private final Stack<Integer> stack = new Stack<>();

    public void push(int value) {

        // we don't allow values that overflow int/2 range
        int r = Math.addExact(value, value);

        if (stack.empty()) {
            stack.push(value);
            min = value;
        } else if (value > min) {
            stack.push(value);
        } else {
            stack.push(r - min);
            min = value;
        }
    }

    // pop() doesn't return the value since this 
    // may be a wrong value (a value that was not pushed by the client)!
    public void pop() {

        if (stack.empty()) {
            throw new EmptyStackException();
        }

        int top = stack.peek();
        if (top < min) {
            min = 2 * min - top;
        }
        stack.pop();
    }

    public int min() {
        return min;
    }
}
