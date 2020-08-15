package coding.challenge;
 
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[][] arrs = {
            {1, 2, 32, 46}, 
            {-4, 5, 15, 18, 20}, 
            {3}, 
            {6, 8}, 
            {-2, -1, 0}
        };

        int[] result = MergeArrays.merge(arrs, arrs.length);
        System.out.println(Arrays.toString(result));
    }
}
