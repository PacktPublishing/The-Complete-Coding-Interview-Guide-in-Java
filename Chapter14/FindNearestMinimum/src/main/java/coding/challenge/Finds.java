package coding.challenge;
 
import java.util.Stack;

public final class Finds {

    private Finds() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void leftSmaller(int arr[]) {

        Stack<Integer> stack = new Stack<>();

        // While the top element of the stack is greater than 
        // equal to arr[i] remove it from the stack        
        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            // if stack is empty there is no left smaller element
            if (stack.empty()) {
                System.out.print("_, ");
            } else {
                // the top of the stack is the left smaller element
                System.out.print(stack.peek() + ", ");
            }
            
            // push arr[i] into the stack
            stack.push(arr[i]);
        }
    }
}
