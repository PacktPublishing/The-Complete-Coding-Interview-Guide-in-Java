package coding.challenge;

public class Main {

    public static void main(String[] args) {

        int[] m = {7, 11, 11, -5, 13, 13, 13, 15, -4, -3, -4, 15, -2, 0, 0, 0, 14, 3, 7, 42, 3};
        int k = 5;

        System.out.println("Array: " + java.util.Arrays.toString(m));

        Arrays.find(m, k);
    }
}
