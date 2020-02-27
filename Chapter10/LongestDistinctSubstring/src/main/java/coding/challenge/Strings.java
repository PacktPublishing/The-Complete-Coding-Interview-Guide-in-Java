package coding.challenge;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    private static final int ASCII_CODES = 256;

    public static String longestDistinctSubstring(String str) {

        if (str == null || str.isBlank()) {
            return "";
        }

        // flag characters present in current window
        boolean[] flagWindow = new boolean[ASCII_CODES];

        // longest substring boundaries
        int left = 0;
        int right = 0;

        // wl and wr represents the sliding window boundaries
        for (int wl = 0, wr = 0; wr < str.length(); wr++) {

            // character is present in current window
            if (flagWindow[str.charAt(wr)]) {
                // remove all characters from the left of the window till the current character
                while (str.charAt(wl) != str.charAt(wr)) {
                    flagWindow[str.charAt(wl)] = false;
                    wl++;
                }

                // remove current character
                wl++;
            } else {
                // current character is not in the current so we add it
                flagWindow[str.charAt(wr)] = true;

                // update maximum window size if necessary
                if ((right - left) < (wr - wl)) {
                    left = wl;
                    right = wr;
                };
            }
        }

        // return longest substring
        return str.substring(left, right + 1);
    }
}
