package coding.challenge;
 
import java.util.Arrays;

public final class Pythagoreans {

    private Pythagoreans() {
        throw new AssertionError("Cannot be instantiated");
    }

    /* O(n^2) */
    public static void triplet(int arr[]) {

        int len = arr.length;

        // Step1
        for (int i = 0; i < len; i++) {
            arr[i] = arr[i] * arr[i];
        }
        
        // Step 2
        Arrays.sort(arr);             

        // Steps 3, 4, and 5
        for (int i = len - 1; i >= 2; i--) {  
            
            int b = 0; 
            int c = i - 1; 
            
            // Step 6
            while (b < c) {
                
                // Step 6c
                if (arr[b] + arr[c] == arr[i]) {
                    System.out.println("Triplet: " + Math.sqrt(arr[b]) + ", "
                            + Math.sqrt(arr[c]) + ", " + Math.sqrt(arr[i]));
                    b++;
                    c--;
                }
                
                // Steps 6a and 6b
                if (arr[b] + arr[c] < arr[i]) {
                    b++;
                } else {
                    c--;
                }
            }
            
        }
    }
}
