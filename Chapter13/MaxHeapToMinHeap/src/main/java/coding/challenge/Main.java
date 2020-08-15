package coding.challenge;
 
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /*        
              40
            /    \
          37      25
         /  \    /  \   
        33  34  20   22         
         */
        
        // max heap
        int arrMaxHeap[] = {40, 37, 25, 33, 34, 20, 22};
        int arrMinHeap[] = {20, 33, 22, 37, 34, 25, 40};
        
        System.out.println("Max heap: " + Arrays.toString(arrMaxHeap));        
        Heaps.convertToMinHeap(arrMaxHeap);
        System.out.println("Min heap: " + Arrays.toString(arrMaxHeap));        
        
        System.out.println("\n\nMin heap: " + Arrays.toString(arrMinHeap));        
        Heaps.convertToMaxHeap(arrMinHeap);
        System.out.println("Max heap: " + Arrays.toString(arrMinHeap));        
    }
}
