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

        // find (in the unsorted part) the index having the minimum 
        // element and move this element to the rear of the queue
        for (int i = 1; i <= queue.size(); i++) {
            
            int minIndex = minIndex(queue, queue.size() - i);
            moveMinElementToRear(queue, minIndex);
        }
    }

    // find the index of the minimum element between the front and the sortIndex 
    private static int minIndex(Queue<Integer> queue, int sortIndex) {

        int minIndex = -1;
        int minElement = Integer.MAX_VALUE;

        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {

            int currentElement = queue.peek();

            // dequeue
            queue.poll();

            // avoid traversing the sorted part of the queue            
            if (currentElement <= minElement && i <= sortIndex) {
                minIndex = i;
                minElement = currentElement;
            }

            // enqueue back
            queue.add(currentElement);
        }

        return minIndex;
    }

    // move the given minimum element to rear of the queue 
    private static void moveMinElementToRear(Queue<Integer> queue, int minIndex) {

        int minElement = 0;

        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {

            int currentElement = queue.peek();
            queue.poll();

            if (i != minIndex) {
                queue.add(currentElement);
            } else {
                minElement = currentElement;
            }
        }

        // enqueue the minimum element at the rear of the queue
        queue.add(minElement);
    }
}
