package coding.challenge;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public final class NoDuplicatePermutation {

    private NoDuplicatePermutation() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static List<String> permute(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Collections.emptyList();
        }

        return permute("", str.length(), charactersMap(str));
    }

    private static List<String> permute(String prefix, int strlength,
            Map<Character, Integer> characters) {

        List<String> permutations = new ArrayList<>();

        if (strlength == 0) {
            permutations.add(prefix);
        } else {

            // fetch next char and generate remaining permutations
            for (Character c : characters.keySet()) {

                int count = characters.get(c);

                if (count > 0) {
                    characters.put(c, count - 1);
                    permutations.addAll(permute(prefix + c, strlength - 1, characters));
                    characters.put(c, count);
                }
            }
        }

        return permutations;
    }

    private static Map<Character, Integer> charactersMap(String str) {

        Map<Character, Integer> characters = new HashMap<>();

        BiFunction<Character, Integer, Integer> count = (k, v)
                -> ((v == null) ? 1 : ++v);

        for (char c : str.toCharArray()) {
            characters.compute(c, count);
        }

        return characters;
    }
}
