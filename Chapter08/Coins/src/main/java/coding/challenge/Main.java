package coding.challenge;

public class Main {

    public static void main(String[] args) {

        Coins coin = new Coins();
        System.out.println("Count (plain recursion): " + coin.calculateChange(25));
        System.out.println("Count (Memoization): " + coin.calculateChange(25));
    }

}
