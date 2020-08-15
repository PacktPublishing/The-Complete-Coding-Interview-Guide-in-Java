package coding.challenge;
 
import coding.challenge.exception.OverflowException;
import coding.challenge.exception.UnderflowException;

public class Main {

    public static void main(String[] args)
            throws OverflowException, UnderflowException {

        ThreeStack ts = new ThreeStack(10);

        // 0 - this is the first stack
        // 1 - this is the second stack
        // 2 - this is the third stack
        
        // push 2, 12 and 5 in the second stack
        ts.push(1, 2);
        ts.push(1, 12);
        ts.push(1, 5);
        ts.printStacks();

        System.out.println("----------------------------------------");

        // push 91, 21 in the third stack and pop from the second stack
        ts.push(2, 91);
        ts.push(2, 21);
        int value = ts.pop(1);
        System.out.println("\nPop from second stack: " + value);
        ts.printStacks();

        System.out.println("----------------------------------------");

        // push 23, 11 and 3 in the first stack
        ts.push(0, 23);
        ts.push(0, 11);
        ts.push(0, 3);
        ts.printStacks();

        System.out.println("----------------------------------------");

        // pop one node from each stack
        int value1 = ts.pop(0);
        int value2 = ts.pop(1);
        int value3 = ts.pop(2);
        ts.printStacks();

        System.out.println();
        System.out.println("Pop: " + value1);
        System.out.println("Pop: " + value2);
        System.out.println("Pop: " + value3);
    }
}
