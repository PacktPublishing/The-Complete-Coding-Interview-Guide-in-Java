package coding.challenge;

public final class BinarySearch {

    private BinarySearch() {
        throw new AssertionError("Cannot be instantiated");
    }

    /* Binary search iterative */
    public static int runIterative(int[] arr, int p) {

        // the search space is the whole array
        int left = 0;
        int right = arr.length - 1;

        // while the search space has at least one element
        while (left <= right) {

            // half the search space
            int mid = (left + right) / 2;

            // if domain overflow can happen then use:
            // int mid = left + (right - left) / 2;
            // int mid = right - (right - left) / 2;
            
            // we found the searched element 
            if (p == arr[mid]) {
                return mid;
            } // discard all elements in the right of the search space including 'mid'
            else if (p < arr[mid]) {
                right = mid - 1;
            } // discard all elements in the left of the search space including 'mid'
            else {
                left = mid + 1;
            }
        }

        // by convention, -1 means element not found into the array
        return -1;
    }

    /* Binary search recursive */
    public static int runRecursive(int[] arr, int left, int right, int p) {

        // recursion base case (search space was covered)
        if (left > right) {
            return -1;
        }

        // half the search space
        int mid = (left + right) / 2;

        // if domain overflow can happen then use:
        // int mid = left + (right - left) / 2;
        
        // we found the searched element 
        if (p == arr[mid]) {
            return mid;
        } // discard all elements in the right of the search space including 'mid'
        else if (p < arr[mid]) {
            return runRecursive(arr, left, mid - 1, p);
        } // discard all elements in the left of the search space including 'mid'
        else {
            return runRecursive(arr, mid + 1, right, p);
        }
    }
}
