package coding.challenge;

public class Main {

    public static void main(String[] args) {

        int A[] = {5, 5, 2, 3, 1, -2, 33, -1};
        int k = 5;
        
        System.out.println("Before: " + java.util.Arrays.toString(A));
        
        Arrays.rightRotate(A, k);
        
        System.out.println("After: " + java.util.Arrays.toString(A));
    }
}
