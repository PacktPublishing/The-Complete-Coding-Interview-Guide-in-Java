package coding.challenge;
 
public final class MagicIndex {

    private MagicIndex() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int find(int[] arr) {

        if (arr == null) {
            return -1;
        }

        return find(arr, 0, arr.length - 1);
    }

    private static int find(int[] arr, int startIndex, int endIndex) {

        if (startIndex > endIndex) {
            return -1; // return an invalid index
        }

        int middleIndex = (startIndex + endIndex) / 2;   // halved the indexes        
        int value = arr[middleIndex];                    // value of middle index        
        if (value == middleIndex) {                      // if the value and index are equal then this is a magic index
            return middleIndex;
        }

        // search from middle of the array to the left       
        int leftIndex = find(arr, startIndex, Math.min(middleIndex - 1, value));
        if (leftIndex >= 0) {
            return leftIndex;
        }

        // search from middle of the array to the right               
        return find(arr, Math.max(middleIndex + 1, value), endIndex);
    }
}
