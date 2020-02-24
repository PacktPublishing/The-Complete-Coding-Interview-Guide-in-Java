package coding.challenge;

import coding.challenge.exception.OverflowException;
import coding.challenge.exception.UnderflowException;

public class ThreeStack {

    private static final int STACK_CAPACITY = 15;

    private int size;                               // stack size
    private int nextFreeSlot;                       // next free slot in array

    private StackNode[] nodes;                      // the stacks

    private final int[] pointers = {-1, -1, -1};    // maintain the parent for each node

    ThreeStack() {
        nodes = new StackNode[STACK_CAPACITY];
        initialize();
    }

    public void push(int stackNumber, int value) throws OverflowException {

        int stack = stackNumber - 1;
        int free = fetchIndexOfFreeSlot();
        int top = pointers[stack];
        StackNode node = nodes[free];

        // link the free node to the current stack
        node.value = value;
        node.link = top;

        // set new top
        pointers[stack] = free;
    }

    public StackNode pop(int stackNumber) throws UnderflowException {

        int stack = stackNumber - 1;
        int top = pointers[stack];

        if (top == -1) {
            throw new UnderflowException("Stack Underflow");
        }

        StackNode node = nodes[top]; // get the top node

        pointers[stack] = node.link;
        freeNode(top);

        return node;
    }

    public void printStacks() {
        for (int i = 0; i < 3; i++) {
            System.out.println("\nStack number: " + (i + 1));
            int s = pointers[i];
            while (s != -1) {
                System.out.println(nodes[s]);
                s = nodes[s].link;
            }
        }
    }

    private int fetchIndexOfFreeSlot() throws OverflowException {

        if (size >= STACK_CAPACITY) {
            throw new OverflowException("Stack Overflow");
        }

        // get next free slot in array
        int free = nextFreeSlot;

        // set next free slot in array and increase size
        nextFreeSlot = nodes[free].link;
        size++;

        return free;
    }

    private void freeNode(int index) {

        nodes[index].link = nextFreeSlot;
        nextFreeSlot = index;

        size--;
    }

    private void initialize() {
        for (int i = 0; i < STACK_CAPACITY; i++) {
            nodes[i] = new StackNode(0, i + 1);
        }
    }
}
