package coding.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

public final class Queues {
 
    private Queues() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void sort(Queue<Integer> queue) {

        if (queue == null || queue.size() < 2) {
            return;
        }

        // this is the extra queue
        Queue<Integer> extraQueue = new ArrayDeque();

        int count = 0;            // count the processed elements
        boolean sorted = false;   // flag when sorting is done

        int queueSize = queue.size();   // size of the given queue
        int lastElement = queue.peek(); // we start from the top of the given queue

        while (!sorted) {
            // if the last element is smaller than the top element in 
            // the given queue then poll it from the given 
            // queue and push it into the extra queue
            if (lastElement <= queue.peek()) {
                lastElement = queue.poll();
                extraQueue.add(lastElement);
            } // if the last element is bigger than the top element 
            // in the given queue then we poll it and put it back to the rear 
            // of the given queue (it will be processed later)
            else {
                queue.add(queue.poll());
            }

            // still have elements to process
            count++;
            if (count != queueSize) {
                continue;
            }

            // we check the length of the extra (sorted) queue
            // to see if we've done our job
            if (extraQueue.size() == queueSize) {
                sorted = true;
            }

            // we dump all the elements to the given queue            
            while (extraQueue.size() > 0) {
                queue.add(extraQueue.poll());
                lastElement = queue.peek();
            }

            count = 0;
        }
    }
}
