package coding.challenge;

import java.util.regex.Pattern;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean isRotation(String str1, String str2) {

        if (str1 == null || str2 == null || str1.isBlank() || str2.isBlank()) {
            return false;
        }

        if (str1.length() != str2.length()) {
            return false;
        }

        return contains((str1 + str1), str2);
    }

    private static boolean contains(String text, String subtext) {
        return text.matches("(?i).*" + Pattern.quote(subtext) + ".*");
    }
}
