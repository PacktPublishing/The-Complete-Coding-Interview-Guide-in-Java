package coding.challenge;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Permutation {

    public void permuteAndPrint(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return;
        }

        permuteAndPrint("", str);
    }

    private void permuteAndPrint(String prefix, String str) {

        int n = str.length();
        if (n == 0) {
            System.out.print(prefix + " ");
        } else {
            for (int i = 0; i < n; i++) {
                permuteAndPrint(prefix + str.charAt(i),
                        str.substring(i + 1, n) + str.substring(0, i));
            }
        }
    }

    public Set<String> permuteAndStore(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Collections.emptySet();
        }

        return permuteAndStore("", str);
    }

    private Set<String> permuteAndStore(String prefix, String str) {

        Set<String> permutations = new HashSet<>();

        int n = str.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutations.addAll(permuteAndStore(prefix + str.charAt(i),
                        str.substring(i + 1, n) + str.substring(0, i)));
            }
        }
        return permutations;
    }

}
