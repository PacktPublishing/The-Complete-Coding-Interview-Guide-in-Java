package coding.challenge;

public class Main {

    public static void main(String[] args) {

        // sample of the array:
        // 1, 3, 5, 7, 3 * 3, 3 * 5, 3 * 7, 5 * 5, 3 * 3 * 3, 5 * 7, 3 * 3 * 5, 7 * 7 ...
        int result1 = Numbers.kth1(7);
        int result2 = Numbers.kth2(7);

        System.out.println("Result: " + result1 + "  |  " + result2);
    }
}
