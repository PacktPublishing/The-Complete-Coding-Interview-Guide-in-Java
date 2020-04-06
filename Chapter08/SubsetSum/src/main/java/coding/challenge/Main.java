package coding.challenge;

public class Main {

    public static void main(String[] args) {
      
        int[] arr = { 3, 2, 7, 4, 5, 1, 6};
        
        int[] subset = new int[arr.length];
        
        System.out.println("Recursive approach:");
        Subsets.findSumRecursive(arr, 0, 0, 5, subset);
        
        System.out.println("\n\nDynamic Programming approach:");
        Subsets.findSumDP(arr, 5);
    }

}
