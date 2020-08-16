package coding.challenge;
 
public final class Arrays {

    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int maxDiff(int arr[]) {

        int len = arr.length;
        int maxDiff = arr[1] - arr[0];
        int marker = arr[0];
        
        for (int i = 1; i < len; i++) {
            
            if (arr[i] - marker > maxDiff) {
                maxDiff = arr[i] - marker;
            }
            
            if (arr[i] < marker) {
                marker = arr[i];
            }
        }
        
        return maxDiff;
    }

}
