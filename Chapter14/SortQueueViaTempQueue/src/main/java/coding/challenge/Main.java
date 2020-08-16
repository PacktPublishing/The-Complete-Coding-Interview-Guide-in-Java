package coding.challenge;
  
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(7);
        queue.add(1);
        queue.add(4);
        queue.add(0);
        queue.add(2);
        queue.add(-4);
        queue.add(-4);
        queue.add(1);
        queue.add(0);
        queue.add(14);
 
        System.out.println("Given queue: " + queue);

        Queues.sort(queue);

        System.out.println("Sorted queue: " + queue);
    }
}
