package coding.challenge;

public class Main {

    public static void main(String[] args) {

        int[] bars = {1, 0, 0, 4, 0, 2, 0, 1, 6, 2, 3};
        // int[] bars = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};  // 25
        // int[] bars = {0, 3, 0, 4, 3, 0, 3, 5, 4, 3, 4, 3}; // 10
        // int[] bars = {1, 0, 2, 2, 4, 0, 1, 5, 2, 1, 6, 1}; // 15
        // int[] bars = {0, 0, 0, 3}; // 0
        // int[] bars = {4, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; // 14
        // int[] bars = {0, 1, 2}; // 0

        int water1 = Bars.trapViaArray(bars);
        int water2 = Bars.trapViaStack(bars);
        int water3 = Bars.trapOptimized(bars);
        System.out.println("Result: " + water1 + " | " + water2 + " | " + water3);
    }

}
