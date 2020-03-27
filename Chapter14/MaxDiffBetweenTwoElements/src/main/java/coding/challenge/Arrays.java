package coding.challenge;

public final class Arrays {

    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int maxDiff(int arr[]) {

        int len = arr.length;
        int maxDiff = arr[1] - arr[0];
        int pivot = arr[0];
        
        for (int i = 1; i < len; i++) {
            
            if (arr[i] - pivot > maxDiff) {
                maxDiff = arr[i] - pivot;
            }
            
            if (arr[i] < pivot) {
                pivot = arr[i];
            }
        }
        
        return maxDiff;
    }

}
