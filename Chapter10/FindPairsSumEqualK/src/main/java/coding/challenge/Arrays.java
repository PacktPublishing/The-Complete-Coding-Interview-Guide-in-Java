package coding.challenge;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Arrays {

    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static List<String> pairs(int[] m, int k) {

        if (m == null || m.length < 2) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();

        java.util.Arrays.sort(m);

        int l = 0;
        int r = m.length - 1;

        while (l < r) {

            int sum = m[l] + m[r];

            if (sum == k) {
                result.add("(" + m[l] + " + " + m[r] + ")");
                l++;
                r--;
            } else if (sum < k) {
                l++;
            } else if (sum > k) {
                r--;
            }
        }

        return result;
    }
}
