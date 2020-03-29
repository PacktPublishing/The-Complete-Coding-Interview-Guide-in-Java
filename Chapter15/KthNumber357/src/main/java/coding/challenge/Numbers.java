package coding.challenge;

import static java.lang.Integer.min;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public final class Numbers {

    private Numbers() {
        throw new AssertionError("Cannot be instantiated");
    }

    /* approach via list */
    public static int kth1(int k) {

        if (k <= 0) {
            return 0;
        }

        int count3 = 0;
        int count5 = 0;
        int count7 = 0;

        List<Integer> list = new ArrayList<>();
        list.add(1);

        while (list.size() <= k + 1) {
            int m = min(min(list.get(count3) * 3, list.get(count5) * 5), list.get(count7) * 7);

            list.add(m);
            if (m == list.get(count3) * 3) {
                count3++;
            }
            if (m == list.get(count5) * 5) {
                count5++;
            }
            if (m == list.get(count7) * 7) {
                count7++;
            }
        }

        return list.get(k - 1);
    }

    /* approach via three queues */
    public static int kth2(int k) {

        if (k <= 0) {
            return 0;
        }

        int minElem = 1;

        Queue<Integer> queue3 = new ArrayDeque<>();
        Queue<Integer> queue5 = new ArrayDeque<>();
        Queue<Integer> queue7 = new ArrayDeque<>();

        // sample of the array:
        // 1, 3, 5, 7, 3 * 3, 3 * 5, 3 *7, 5 * 5, 3 * 3 * 3, 5 * 7, 3 * 3 * 5, 7 * 7 ...
        for (int i = 1; i < k; i++) {
            queue3.add(minElem * 3);
            queue5.add(minElem * 5);
            queue7.add(minElem * 7);

            minElem = min(queue3.peek(), min(queue5.peek(), queue7.peek()));

            if (minElem == queue3.peek()) {
                queue3.poll();
            }
            if (minElem == queue5.peek()) {
                queue5.poll();
            }
            if (minElem == queue7.peek()) {
                queue7.poll();
            }
        }

        return minElem;
    }
}
