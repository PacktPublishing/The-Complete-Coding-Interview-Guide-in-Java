package coding.challenge;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String shrink(String str) {

        if (str == null || str.isBlank()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {

            count++;

            // we don't count whitespaces, we just copy them
            if (!Character.isWhitespace(str.charAt(i))) {

                // if there are no more characters or the next character 
                // is different from the counted one
                if ((i + 1) >= str.length()
                        || str.charAt(i) != str.charAt(i + 1)) {

                    // append to the final result the counted character
                    // and number of consecutive occurrences
                    result.append(str.charAt(i))
                            .append(count);

                    // reset the counter since this sequence was appended to the result
                    count = 0;
                }
            } else {
                result.append(str.charAt(i));
                count = 0;
            }
        }

        // return the result only if it is shorter than the given string
        return result.length() > str.length()
                ? str : result.toString();
    }
}
