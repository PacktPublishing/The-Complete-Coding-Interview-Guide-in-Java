package coding.challenge;

public final class Arrays {

    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int findAbsoluteDistinct(int[] m) {

        if (m == null) {
            return -1;
        }

        int count = m.length;

        int left = 0;
        int right = m.length - 1;

        while (left < right) {

            // remove duplicates elements from the left and right            
            while (left < right && m[left] == m[left + 1]) {
                count--;
                left++;
            }

            while (right > left && m[right] == m[right - 1]) {
                count--;
                right--;
            }

            // only one element is left
            if (left == right) {
                break;
            }

            int sum = m[left] + m[right];

            // decrease the distinct count if zero sum pair is encountered
            if (sum == 0) {
                
                count--;
                
                left++;
                right--;
            } else if (sum < 0) {
                
                left++;
            } else {
                
                right--;
            }
        }

        return count;
    }
}
