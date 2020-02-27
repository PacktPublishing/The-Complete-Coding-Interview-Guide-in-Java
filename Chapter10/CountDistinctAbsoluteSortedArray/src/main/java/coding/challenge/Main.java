package coding.challenge;

public class Main {

    public static void main(String[] args) {

        int[] m = {-3, -3, -2, -1, -1, -1, 0, 1, 1, 1, 2, 2, 3, 5, 6, 7, 7};

        int result = Arrays.findAbsoluteDistinct(m);

        System.out.println("Array: " + java.util.Arrays.toString(m));
        System.out.print("The number of distinct absolute values is: "
                + result);
    }
}
