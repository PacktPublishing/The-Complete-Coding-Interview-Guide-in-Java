package coding.challenge;
 
import coding.challenge.exception.OverflowException;
import coding.challenge.exception.UnderflowException;

public class ThreeStack {

    private static final int NO_OF_STACKS = 3;

    private final int stackCapacity;
    private final int[] values;
    private final int[] stacks;

    public ThreeStack(int stackSize) {

        stackCapacity = stackSize;
        values = new int[stackSize * NO_OF_STACKS];
        stacks = new int[NO_OF_STACKS];
    }

    public void push(int stackNumber, int value) throws OverflowException {

        if (isFull(stackNumber)) {
            throw new OverflowException("Stack Overflow");
        }

        // increment stack pointer and then update the top value
        stacks[stackNumber]++;
        values[fetchTopIndex(stackNumber)] = value;
    }

    public int pop(int stackNumber) throws UnderflowException {

        if (isEmpty(stackNumber)) {
            throw new UnderflowException("Stack Underflow");
        }

        int topIndex = fetchTopIndex(stackNumber);
        int value = values[topIndex];

        values[topIndex] = 0;
        stacks[stackNumber]--;

        return value;
    }

    public int peek(int stackNumber) throws UnderflowException {

        if (isEmpty(stackNumber)) {
            throw new UnderflowException("Stack Underflow");
        }

        return values[fetchTopIndex(stackNumber)];
    }

    public boolean isEmpty(int stackNumber) {
        return stacks[stackNumber] == 0;
    }

    public boolean isFull(int stackNumber) {
        return stacks[stackNumber] == stackCapacity;
    }

    private int fetchTopIndex(int stackNumber) {

        int offset = stackNumber * stackCapacity;
        int size = stacks[stackNumber];

        return offset + size - 1;
    }

    public void printStacks() {
        for (int i = 0; i < NO_OF_STACKS; i++) {

            System.out.println("\nStack number: " + (i+1));            
            
            if (!isEmpty(i)) {
                int topIndex = fetchTopIndex(i);
                while (values[topIndex] != 0 && topIndex > 0) {
                    System.out.println(values[topIndex]);
                    topIndex--;
                }
            } else {
                System.out.println("\nStack number: " + (i+1) + " is empty!");
            }
        }
    }
}
