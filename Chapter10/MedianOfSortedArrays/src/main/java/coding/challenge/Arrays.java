package coding.challenge;
 
public final class Arrays {

    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static float median(int[] q, int[] p) {

        if (q == null || p == null) {
            return -1;
        }

        int lenQ = q.length;
        int lenP = p.length;

        if (lenQ > lenP) {
            swap(q, p);
        }

        int qPointerMin = 0;
        int qPointerMax = q.length;
        int midLength = (q.length + p.length + 1) / 2;

        int qPointer;
        int pPointer;

        while (qPointerMin <= qPointerMax) {

            qPointer = (qPointerMin + qPointerMax) / 2;
            pPointer = midLength - qPointer;

            // perform binary search
            if (qPointer < q.length && p[pPointer - 1] > q[qPointer]) {
                // qPointer must be increased
                qPointerMin = qPointer + 1;
            } else if (qPointer > 0 && q[qPointer - 1] > p[pPointer]) {
                // qPointer must be decreased
                qPointerMax = qPointer - 1;
            } else { // we found the poper qPointer    

                int maxLeft = 0;

                if (qPointer == 0) { // first element on array 'q'?
                    maxLeft = p[pPointer - 1];
                } else if (pPointer == 0) { // first element of array 'p'?
                    maxLeft = q[qPointer - 1];
                } else { // we are somewhere in the middle -> find max
                    maxLeft = Integer.max(q[qPointer - 1], p[pPointer - 1]);
                }

                // if the length of 'q' + 'p' arrays is odd, return max of left
                if ((q.length + p.length) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;

                if (qPointer == q.length) { // last element on array 'q'?
                    minRight = p[pPointer];
                } else if (pPointer == p.length) { // last element on array 'p'?
                    minRight = q[qPointer];
                } else { // we are somewhere in the middle -> find min
                    minRight = Integer.min(q[qPointer], p[pPointer]);
                }

                return (maxLeft + minRight) / 2.0f;
            }
        }
        return -1;
    }

    // we force array 'q' to be smaller than 'p'
    // so that j is always greater than zero
    private static void swap(int[] q, int[] p) {

        int[] aux = q;
        q = p;
        p = aux;
    }

}
