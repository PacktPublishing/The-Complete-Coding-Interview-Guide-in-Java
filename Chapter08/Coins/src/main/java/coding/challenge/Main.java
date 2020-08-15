package coding.challenge;
 
public class Main {

    public static void main(String[] args) {
       
        System.out.println("Count (plain recursion): " + Coins.calculateChange(25));
        System.out.println("Count (Memoization): " + Coins.calculateChange(25));
    }

}
