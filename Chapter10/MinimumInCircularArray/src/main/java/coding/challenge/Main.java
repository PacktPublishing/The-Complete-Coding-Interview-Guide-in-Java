package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int[] m = {7, 11, 12, 13, 15, -4, -3, -2, 0, 1, 1, 3, 4, 7, 7};

        int min = Arrays.findMin(m);

        System.out.println("Array: " + java.util.Arrays.toString(m));
        System.out.println("Min value is: " + min);
    }
}
