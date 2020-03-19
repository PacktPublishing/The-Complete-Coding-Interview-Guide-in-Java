package coding.challenge;

public class Main {

    public static void main(String[] args) {

        int[] ropesLength = {2, 5, 4, 1, 5, 7, 4};
        MinHeap heap = new MinHeap();
        
        int result = heap.minimumCost(ropesLength);
                
        System.out.println("Result: " + result);
    }
}
