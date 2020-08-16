package coding.challenge;
 
public final class Numbers {

    private Numbers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void findNextGreater(int arr[]) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        int min = -1;
        int len = arr.length;

        int prevDigit = arr[arr.length - 1];
        int currentDigit;

        // Step 1: Start from the rightmost digit and find the 
        // first digit that is smaller than the digit next to it. 
        for (int i = len - 2; i >= 0; i--) {
            currentDigit = arr[i];
            if (currentDigit < prevDigit) {
                min = i;
                break;
            }
        }

        // If 'min' is -1 then there is no such digit. This means that the
        // digits are in descending order. There is no greater 
        // number with same set of digits as the given one.
        if (min == -1) {
            System.out.println("There is no greater number with "
                    + "same set of digits as the given one.");
        } else {
            // Steps 2 and 3: Swap 'min' with 'len-1'
            swap(arr, min, len - 1);

            // Step 4: Sort in ascending order all the digits 
            // to the right side of the swapped 'len-1'
            reverse(arr, min + 1, len - 1);

            // print the result
            System.out.print("The next greater number is: ");
            for (int i : arr) {
                System.out.print(i);
            }
        }
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }
}
