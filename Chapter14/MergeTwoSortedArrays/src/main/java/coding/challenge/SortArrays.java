package coding.challenge;
 
public final class SortArrays {

    private SortArrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void merge(int[] p, int[] q) {

        if (p == null || q == null) {
            throw new IllegalArgumentException("The given p and q cannot be null");
        }

        int pLast = p.length - q.length;
        int qLast = q.length;

        if (pLast < 0) {
            throw new IllegalArgumentException("The given p cannot fit q");
        }

        int pIdx = pLast - 1;
        int qIdx = qLast - 1;
        int mIdx = pLast + qLast - 1;

        // merge p and q
        // start from the last element in p and q
        while (qIdx >= 0) {

            if (pIdx >= 0 && p[pIdx] > q[qIdx]) {
                p[mIdx] = p[pIdx];
                pIdx--;
            } else {
                p[mIdx] = q[qIdx];
                qIdx--;
            }

            mIdx--;
        }
    }
}
