package coding.challenge;

import java.util.HashMap;
import java.util.Map;

public final class Arrays {

    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void find(int[] m, int n) {

        if (m == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        if (n <= 0) {
            throw new IllegalArgumentException("The given sub-array size cannot be <= 0");
        }

        // store frequency of elements in current window of size n
        Map<Integer, Integer> frequency = new HashMap<>();

        // count distinct elements in every sub-array of size n
        int countDistinct = 0;

        for (int i = 0; i < m.length; i++) {

            // skip first n elements
            if (i >= n) {
                // Remove first element from the sub-array
                frequency.putIfAbsent(m[i - n], 0);
                frequency.put(m[i - n], frequency.get(m[i - n]) - 1);

                // reduce distinct count if we are left with 0
                if (frequency.get(m[i - n]) == 0) {
                    countDistinct--;
                }
            }

            // add current element to the sub-array 
            frequency.putIfAbsent(m[i], 0);
            frequency.put(m[i], frequency.get(m[i]) + 1);

            // element is for the first time in current window?
            if (frequency.get(m[i]) == 1) {
                countDistinct++;
            }

            if (i >= n - 1) {
                System.out.println("Distinct elements in the "
                        + "sub-array [" + (i - n + 1) + ", " + i + "]" + " is "
                        + countDistinct);
            }
        }
    }
}
