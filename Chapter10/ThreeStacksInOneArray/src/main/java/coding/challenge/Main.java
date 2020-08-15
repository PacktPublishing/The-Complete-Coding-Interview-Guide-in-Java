package coding.challenge;
 
import coding.challenge.exception.OverflowException;
import coding.challenge.exception.UnderflowException;

public class Main {

    public static void main(String[] args) 
            throws OverflowException, UnderflowException {

        ThreeStack ts = new ThreeStack();
        
        // 1 - this is the first stack
        // 2 - this is the second stack
        // 3 - this is the third stack
        
        // push 2, 12 and 5 in the second stack
        ts.push(2, 2);
        ts.push(2, 12);
        ts.push(2, 5);
        ts.printStacks();
        
        System.out.println("----------------------------------------");
        
        // push 91, 21 in the third stack and pop from the second stack
        ts.push(3, 91);
        ts.push(3, 21);
        StackNode sn = ts.pop(2);
        System.out.println("\nPop from second stack: " + sn.value);
        ts.printStacks();
        
        System.out.println("----------------------------------------");
        
        // push 23, 11 and 3 in the first stack
        ts.push(1, 23);
        ts.push(1, 11);
        ts.push(1, 3);
        ts.printStacks();
        
        System.out.println("----------------------------------------");
        
        // pop one node from each stack
        StackNode sn1 = ts.pop(1);
        StackNode sn2 = ts.pop(2);
        StackNode sn3 = ts.pop(3);
        ts.printStacks();
        
        System.out.println();
        System.out.println("Pop: " + sn1.value);
        System.out.println("Pop: " + sn2.value);
        System.out.println("Pop: " + sn3.value);
    }
}
