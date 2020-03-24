package coding.challenge;

public final class UnknownSizeList {

    private UnknownSizeList() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int search(SizelessList sl, int element) {

        if (sl == null) {
            throw new IllegalArgumentException("The given list cannot be null");
        }

        if (element < 0) {
            throw new IllegalArgumentException("The searched element cannot be negative");
        }

        int index = 1;
        while (sl.peekAt(index) != -1 && sl.peekAt(index) < element) {
            index *= 2;
        }

        return binarySearch(sl, element, index / 2, index);
    }

    private static int binarySearch(SizelessList sl, int element, int left, int right) {

        int mid;

        while (left <= right) {

            mid = (left + right) / 2;
            int middle = sl.peekAt(mid);
            if (middle > element || middle == -1) {
                right = mid - 1;
            } else if (middle < element) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
