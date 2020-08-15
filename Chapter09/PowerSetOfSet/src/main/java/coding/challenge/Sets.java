package coding.challenge;
 
import java.util.HashSet;
import java.util.Set;

public final class Sets {

    private Sets() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static Set<Set<Character>> powerSet(char[] set) {

        if (set == null) {
            throw new IllegalArgumentException("The given set cannot be null");
        }

        // total number of subsets (2^n)
        long subsetsNo = (long) Math.pow(2, set.length);

        // store subsets
        Set<Set<Character>> subsets = new HashSet<>();

        // generate each subset one by one
        for (int i = 0; i < subsetsNo; i++) {
            Set<Character> subset = new HashSet<>();

            // check every bit of i
            for (int j = 0; j < set.length; j++) {
                // if j'th bit of i is set, add set[j] to the current subset
                if ((i & (1 << j)) != 0) {
                    subset.add(set[j]);
                }
            }

            subsets.add(subset);
        }

        return subsets;
    }
}
