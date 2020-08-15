package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int[] prices = {200, 500, 1000, 700, 30, 400, 900, 400, 550};

        int resultOneTransaction = Stocks.maxProfitOneTransaction(prices);
        System.out.println("Max profit (one transaction): " + resultOneTransaction);
        
        int resultTwoTransaction = Stocks.maxProfitTwoTransactions(prices);
        System.out.println("Max profit (two transaction): " + resultTwoTransaction);

        int resultUnlimitedTransaction = Stocks.maxProfitUnlimitedTransactions(prices);
        System.out.println("Max profit (unlimited transaction): " + resultUnlimitedTransaction);
        
        int resultOKransaction = Stocks.maxProfitKTransactions(prices, 2);
        System.out.println("Max profit (k=2 transaction): " + resultOKransaction);
    }

}
