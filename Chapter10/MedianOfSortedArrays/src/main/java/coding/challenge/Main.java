package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int[] q = {2, 6, 9, 10, 11, 65, 67};
        int[] p = {1, 5, 17, 18, 25, 28, 39, 77, 88};

        float result = Arrays.median(q, p);

        System.out.println("Array 'q': " + java.util.Arrays.toString(q));
        System.out.println("Array 'p': " + java.util.Arrays.toString(p));
        System.out.println();
        
        System.out.println("Median is: " + result);
    }
}
