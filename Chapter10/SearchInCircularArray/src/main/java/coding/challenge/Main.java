package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int[] m = {11, 14, 23, 24, -1, 3, 5, 6, 8, 9, 10};
        int x = 14;

        int foundIndex = Arrays.find(m, x);
        
        System.out.println("Array: " + java.util.Arrays.toString(m));
        System.out.println("The value " + x + " was found at index " + foundIndex);
    }
}
