package coding.challenge;

public class Main {

    public static void main(String[] args) {

        // initialize an array integers        
        int[] integers = {1, 4, 5, 7, 10, 16, 17, 18, 20, 23, 24, 25, 26, 30, 31, 33};
        int p = 17;

        int resultIterative = BinarySearch.runIterative(integers, p);
        int resultRecursive = BinarySearch.runRecursive(integers, 0, integers.length - 1, p);

        System.out.println("Iterative approach - found at index: " + resultIterative);
        System.out.println("Recursive approach - found at index: " + resultRecursive);
    }
}
