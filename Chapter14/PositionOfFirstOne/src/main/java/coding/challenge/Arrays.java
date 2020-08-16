package coding.challenge;
 
public final class Arrays {

    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int firstOneIndex(int[] arr) {

        if (arr == null) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            
            int middle = 1 + (right - left) / 2;
            
            if (arr[middle] == 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
            
            if (arr[left] == 1) {
                return left;
            }
        }
        
        return -1;
    }
}
