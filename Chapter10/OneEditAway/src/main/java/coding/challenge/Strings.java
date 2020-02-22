package coding.challenge;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean isOneEditAway(String first, String second) {

        if (first == null || second == null
                || first.isBlank() || second.isBlank()) {
            return false;
        }

        // if the difference between the strings is bigger than 1 
        // then they are at more than one edit away
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        // get shorter and longer string
        String shorter = first.length() < second.length() ? first : second;
        String longer = first.length() < second.length() ? second : first;

        int is = 0;
        int il = 0;
        boolean marker = false;
        while (is < shorter.length() && il < longer.length()) {

            if (shorter.charAt(is) != longer.charAt(il)) {

                // first difference was found
                // at the second difference we return false
                if (marker) {
                    return false;
                }

                marker = true;

                if (shorter.length() == longer.length()) {
                    is++;
                }
            } else {
                is++;
            }
            il++;
        }
        
        return true;
    }
}
