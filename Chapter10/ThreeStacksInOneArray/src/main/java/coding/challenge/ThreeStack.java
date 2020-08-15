package coding.challenge;
 
import coding.challenge.exception.OverflowException;
import coding.challenge.exception.UnderflowException;

public class ThreeStack {

    private static final int STACK_CAPACITY = 15;

    private int size;                               // stack size
    private int nextFreeSlot;                       // next free slot in array

    private final StackNode[] theArray;             // the array of stacks 

    private final int[] backLinks = {-1, -1, -1};   // maintain the parent for each node

    ThreeStack() {
        theArray = new StackNode[STACK_CAPACITY];
        initializeSlots();
    }

    public void push(int stackNumber, int value) throws OverflowException {
        
        if(stackNumber < 1 || stackNumber > 3) {
            throw new IllegalArgumentException("Choose between stack number 1, 2 or 3");
        }

        int stack = stackNumber - 1;
        int free = fetchIndexOfFreeSlot();
        int top = backLinks[stack];
        StackNode node = theArray[free];

        // link the free node to the current stack
        node.value = value;
        node.backLink = top;

        // set new top
        backLinks[stack] = free;
    }

    public StackNode pop(int stackNumber) throws UnderflowException {
        
        if(stackNumber < 1 || stackNumber > 3) {
            throw new IllegalArgumentException("Choose between stack number 1, 2 or 3");
        }

        int stack = stackNumber - 1;
        int top = backLinks[stack];

        if (top == -1) {
            throw new UnderflowException("Stack Underflow");
        }

        StackNode node = theArray[top]; // get the top node

        backLinks[stack] = node.backLink;
        freeSlot(top);

        return node;
    }

    public void printStacks() {                
        for (int i = 0; i < 3; i++) {
            
            System.out.println("\nStack number: " + (i + 1));
            int s = backLinks[i];
            while (s != -1) {
                System.out.println(theArray[s]);
                s = theArray[s].backLink;
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
        nextFreeSlot = theArray[free].backLink;
        size++;

        return free;
    }

    private void freeSlot(int index) {

        theArray[index].backLink = nextFreeSlot;
        nextFreeSlot = index;

        size--;
    }

    private void initializeSlots() {
        for (int i = 0; i < STACK_CAPACITY; i++) {
            theArray[i] = new StackNode(0, i + 1);
        }
    }
}
