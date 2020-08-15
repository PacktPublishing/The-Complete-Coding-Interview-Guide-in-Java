package coding.challenge;
 
public final class SimplePermutation {

    private SimplePermutation() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void permute(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return;
        }

        permute("", str);
    }

    private static void permute(String prefix, String str) {

        int n = str.length();
        if (n == 0) {
            System.out.print(prefix + " ");
        } else {
            for (int i = 0; i < n; i++) {
                permute(prefix + str.charAt(i),
                        str.substring(i + 1, n) + str.substring(0, i));
            }
        }
    }
}
