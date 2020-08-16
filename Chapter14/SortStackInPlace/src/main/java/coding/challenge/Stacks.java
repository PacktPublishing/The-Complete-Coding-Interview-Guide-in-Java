package coding.challenge;
 
import java.util.Stack;

public final class Stacks {

    private Stacks() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void sort(Stack<Integer> stack) {
        
        if(stack == null) {
            throw new IllegalArgumentException("The given stack cannot be empty");
        }

        // stack is empty (base case)
        if (stack.isEmpty()) {
            return;
        }

        // remove the top element
        int top = stack.pop();

        // apply recursion for the remaining elements in the stack
        sort(stack);

        // insert the popped element back in the sorted stack
        sortedInsert(stack, top);
    }

    private static void sortedInsert(Stack<Integer> stack, int element) {

        // the stack is empty or the element 
        // is greater than all elements in the stack (base case)
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }

        // the element is smaller than the top element, so remove the top element       
        int top = stack.pop();

        // apply recursion for the remaining elements in the stack
        sortedInsert(stack, element);

        // insert the popped element back in the stack
        stack.push(top);
    }
}
