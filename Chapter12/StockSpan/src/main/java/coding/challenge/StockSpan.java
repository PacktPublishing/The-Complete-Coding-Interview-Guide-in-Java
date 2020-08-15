package coding.challenge;
 
import java.util.Stack;

public class StockSpan {

    private StockSpan() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int[] stockSpan(int[] stockPrices) {

        if (stockPrices == null) {
            throw new IllegalArgumentException("Prices array cannot be null");
        }

        Stack<Integer> dayStack = new Stack();
        int[] spanResult = new int[stockPrices.length];

        spanResult[0] = 1; // first day has span 1
        dayStack.push(0);

        for (int i = 1; i < stockPrices.length; i++) {

            // pop until we find a price on stack which is greater than 
            // the current day's price or there are no more days left
            while (!dayStack.empty() && stockPrices[i] > stockPrices[dayStack.peek()]) {
                dayStack.pop();
            }

            // if there is no price greater than the current day's price 
            // then the stock span is the numbers of days
            if (dayStack.empty()) {
                spanResult[i] = i + 1;
            } else {
                // if there is a price greater than the current day's price
                // then the stock span is the difference between the current day and that day
                spanResult[i] = i - dayStack.peek();
            }

            // push current day onto top of stack
            dayStack.push(i);
        }

        return spanResult;
    }
}
