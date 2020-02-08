package coding.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

public class Josephus {

    // plain recursive 
    int josephus(int n, int k) {
        if (n == 1) {
            return 1;
        } else {
            return (josephus(n - 1, k) + k - 1) % n + 1;
        }
    }

    // using Queue
    public void printJosephus(int n, int k) {

        Queue<Integer> circle = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        while (circle.size() != 1) {
            for (int i = 1; i <= k; i++) {
                int eliminated = circle.poll();

                if (i == k) {
                    System.out.println("Eliminated: " + eliminated);
                    break;
                }

                circle.add(eliminated);
            }
        }

        System.out.println("Using queue! Survivor: " + circle.peek());
    }

}
