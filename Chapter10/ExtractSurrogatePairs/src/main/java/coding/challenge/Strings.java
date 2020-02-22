package coding.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static List<Integer> extract(String str) {

        if (str == null || str.isBlank()) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {

            int cp = str.codePointAt(i);
            if (i < str.length() - 1 && str.codePointCount(i, i + 2) == 1) {
                result.add(cp);
                result.add(str.codePointAt(i+1));
                i++;
            }

            /*
            // or, like this 
            int cp = str.codePointAt(i);               
            if (Character.charCount(cp) == 2) { // 2 means a suroggate pair
                result.add(cp);
                result.add(str.codePointAt(i+1));
                i++;
            } 
            */
        }

        return result;
    }
}
