package coding.challenge;
 
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

public class MyStack {

    private static final int STACK_SIZE = 3;

    private final LinkedList<Stack<Integer>> stacks = new LinkedList<>();

    public void push(int value) {

        // if there is no stack or the last stack is full
        if (stacks.isEmpty() || stacks.getLast().size() >= STACK_SIZE) {

            // create a new stack and push the value into it
            Stack<Integer> stack = new Stack<>();
            stack.push(value);

            // add the new stack into the list of stacks
            stacks.add(stack);
        } else {
            // add the value in the last stack
            stacks.getLast().push(value);
        }
    }

    public Integer pop() {

        if (stacks.isEmpty()) {
            throw new EmptyStackException();
        }

        // find the last stack
        Stack<Integer> lastStack = stacks.getLast();

        // pop the value from the last stack
        int value = lastStack.pop();

        // if last stack is empty we can remove it from the list of stacks
        removeStackIfEmpty();

        return value;
    }

    public Integer popAt(int stackIndex) {

        if (stacks.isEmpty()) {
            throw new EmptyStackException();
        }

        if (stackIndex < 0 || stackIndex >= stacks.size()) {
            throw new IllegalArgumentException("The given index is out of bounds");
        }

        // get the value from the correspondind stack
        int value = stacks.get(stackIndex).pop();

        // since we pop an element we must shift the remaining elements        
        shift(stackIndex);

        // if last stack is empty we can remove it from the list of stacks
        removeStackIfEmpty();

        return value;
    }

    private void shift(int index) {

        for (int i = index; i < stacks.size() - 1; ++i) {
            Stack<Integer> currentStack = stacks.get(i);
            Stack<Integer> nextStack = stacks.get(i + 1);

            currentStack.push(nextStack.remove(0));
        }
    }

    private void removeStackIfEmpty() {
        if (stacks.getLast().isEmpty()) {
            stacks.removeLast();
        }
    }

    public void printStacks() {
        for (int i = 0; i < stacks.size(); i++) {
            System.out.println("\nStack " + (i) + ": ");
            System.out.print("BOTTOM -> ");
            for (int value : stacks.get(i)) {
                System.out.print(value + " ");
            }
            System.out.print(" <- TOP\n");
        }
    }
}
