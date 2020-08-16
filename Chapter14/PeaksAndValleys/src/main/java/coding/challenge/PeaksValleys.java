package coding.challenge;
 
public final class PeaksValleys {

    private PeaksValleys() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i += 2) {
            
            int maxFoundIndex = maxElementIndex(arr, i - 1, i, i + 1);
            if (i != maxFoundIndex) {
                swap(arr, i, maxFoundIndex);
            }            
        }
    }

    private static int maxElementIndex(int[] arr, int left, int middle, int right) {

        int arrLength = arr.length;
        int leftElement = left >= 0 && left < arrLength ? arr[left] : Integer.MIN_VALUE;
        int middleElement = middle >= 0 && middle < arrLength ? arr[middle] : Integer.MIN_VALUE;
        int rightElement = right >= 0 && right < arrLength ? arr[right] : Integer.MIN_VALUE;

        int maxElement = Math.max(leftElement, Math.max(middleElement, rightElement));

        if (leftElement == maxElement) {
            return left;
        } else if (middleElement == maxElement) {
            return middle;
        } else {
            return right;
        }
    }

    /* helper method to swap two elements of the array */
    private static void swap(int[] arr, int x, int y) {       
        int z = arr[x];
        arr[x] = arr[y];
        arr[y] = z;
    }
}
