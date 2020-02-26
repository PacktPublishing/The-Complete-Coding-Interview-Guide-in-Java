package coding.challenge;

public class Main {

    public static void main(String[] args) {

        int[] m = {11, 14, 23, 24, -1, 3, 5, 6, 8, 10};
        int n = -1;

        int foundIndex = Arrays.find(m, n);
        
        System.out.println("Array: " + java.util.Arrays.toString(m));
        System.out.println("Result: " + foundIndex);
    }
}
