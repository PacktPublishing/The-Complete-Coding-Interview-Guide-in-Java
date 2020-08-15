package coding.challenge;
 
public final class Arrays {

    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int findMax(int[] m) {

        if (m == null || m.length == 0) {
            return -1;
        }

        int left = 0;
        int right = m.length - 1;

        while ((left + 1) < right) {

            int middle = left + (right - left) / 2;

            if (m[middle] == m[left]) {
                left = middle;  // going backward
            } else if (m[middle] < m[left]) {
                right = middle;
            } else {
                left = middle;
            }
        }

        if (m[right] >= m[left]) {
            return m[right];
        } else {
            return m[left];
        }
    }
}
