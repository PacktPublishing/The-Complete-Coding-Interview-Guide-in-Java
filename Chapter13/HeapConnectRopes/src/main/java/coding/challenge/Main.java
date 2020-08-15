package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int[] ropesLength = {1, 4, 6, 3};
        MinHeap heap = new MinHeap();
        
        int result = heap.minimumCost(ropesLength);
                
        System.out.println("Result: " + result);
    }
}
