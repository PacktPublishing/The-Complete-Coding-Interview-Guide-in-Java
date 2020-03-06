package coding.challenge;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int stockPrices[] = {55, 34, 22, 23, 27, 88, 9, 6, 5, 65};
        int[] spanResult = StockSpan.stockSpan(stockPrices);

        System.out.println("Stock prices: " + Arrays.toString(stockPrices));
        System.out.println("Span results: " + Arrays.toString(spanResult));
    }
}
