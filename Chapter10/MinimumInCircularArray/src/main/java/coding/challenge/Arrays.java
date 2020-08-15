package coding.challenge;
 
public final class Arrays {

    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int findMin(int[] m) {

        if (m == null || m.length == 0) {
            return -1;
        }

        int left = 0;
        int right = m.length - 1;

        while ((left + 1) < right) {

            int middle = left + (right - left) / 2;

            if (m[middle] == m[right]) {
                right--; // for duplicates
            } else if (m[middle] > m[right]) {
                left = middle;
            } else {
                right = middle;
            }
        }

        if (m[left] <= m[right]) {
            return m[left];
        }

        return m[right];
    }
}
