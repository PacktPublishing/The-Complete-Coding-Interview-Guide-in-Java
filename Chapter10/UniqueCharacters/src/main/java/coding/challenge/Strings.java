package coding.challenge;

import java.util.HashMap;
import java.util.Map;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean isUnique(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return false;
        }

        Map<Character, Integer> chars = new HashMap<>();

        // or use for(char ch: str.toCharArray()) { ... }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (!Character.isWhitespace(ch)) {
                if (chars.putIfAbsent(ch, 1) != null) {
                    return false;
                }
            }
        }

        return true;
    }
}
