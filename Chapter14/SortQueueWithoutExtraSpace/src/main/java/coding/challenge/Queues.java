package coding.challenge;
 
import java.util.Queue;

public final class Queues {

    private Queues() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void sort(Queue<Integer> queue) {

        if (queue == null || queue.size() < 2) {
            return;
        }

        // traverse the unsorted part of the queue
        for (int i = 1; i <= queue.size(); i++) {

            moveMinToRear(queue, queue.size() - i);
        }
    }

    // find (in the unsorted part) the minimum
    // element and move this element to the rear of the queue
    private static void moveMinToRear(Queue<Integer> queue, int sortIndex) {

        int minElement = Integer.MAX_VALUE;
        boolean flag = false;

        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {

            int currentElement = queue.peek();

            // dequeue
            queue.poll();

            // avoid traversing the sorted part of the queue            
            if (currentElement <= minElement && i <= sortIndex) {

                // if we found earlier a minimum then 
                // we put it back into the queue since
                // we just found a new minimum
                if (flag) {
                    queue.add(minElement);
                }

                flag = true;
                minElement = currentElement;
            } else {
                // enqueue the current element which is not the minimum
                queue.add(currentElement);
            }
        }

        // enqueue the minimum element
        queue.add(minElement);
    }
}
