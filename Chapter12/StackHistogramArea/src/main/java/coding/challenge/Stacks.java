package coding.challenge;
 
import java.util.Stack;

public final class Stacks {

    private Stacks() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int maxAreaUsingStack(int[] histogram) {

        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        for (int bar = 0; bar <= histogram.length; bar++) {

            int barHeight;
            if (bar == histogram.length) {
                barHeight = 0; // take into account last bar
            } else {
                barHeight = histogram[bar];
            }
            
            while (!stack.empty() && barHeight < histogram[stack.peek()]) {
                                
                // we found a bar smaller than the one from the stack                
                int top = stack.pop();

                // find left boundary
                int left = stack.isEmpty() ? -1 : stack.peek();
                
                // find the width of the rectangular area 
                int areaRectWidth = bar - left - 1;
                
                // compute area of the current rectangle
                int area = areaRectWidth * histogram[top];
                maxArea = Integer.max(area, maxArea);
            }

            // add current bar (index) into the stack
            stack.push(bar);
        }        
        
        return maxArea;
    }
}
