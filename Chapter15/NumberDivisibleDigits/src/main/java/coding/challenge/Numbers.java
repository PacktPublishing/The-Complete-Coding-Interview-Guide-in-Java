package coding.challenge;
 
public final class Numbers {

    private Numbers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean isDivisible(int n) {

        int t = n;

        while (n > 0) {

            int k = n % 10;

            if (k != 0 && t % k != 0) {
                return false;
            }

            n /= 10;
        }

        return true;
    }
}
