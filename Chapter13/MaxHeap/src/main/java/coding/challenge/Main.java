package coding.challenge;

public class Main {

    public static void main(String[] args) {

        /*        
              40
            /    \
          47      45
         /  \    /  
        11   3  44         
         */
        MaxHeap<Integer> maxHeap = new MaxHeap();

        maxHeap.add(3);
        maxHeap.add(32);
        maxHeap.add(1);
        maxHeap.add(10);
        maxHeap.add(82);
        maxHeap.add(-2);
        maxHeap.add(13);
        maxHeap.add(63);
        maxHeap.add(21);
        maxHeap.add(93);
        maxHeap.add(8);

        System.out.println("Print heap: ");
        maxHeap.printHeap();

        while (maxHeap.size() > 0) {
            int size = maxHeap.size();
            int peek = maxHeap.peek();
            int poll = maxHeap.poll();
            System.out.println("Peek: " + peek + " Poll: " + poll + " Size: " + size);
            System.out.println("Print heap: ");
            maxHeap.printHeap();
        }
    }
}
