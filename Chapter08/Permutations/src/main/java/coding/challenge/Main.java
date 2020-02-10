package coding.challenge;

import java.util.Set;

public class Main {

    private static final String TEXT = "test";

    public static void main(String[] args) {

        Permutation permutation = new Permutation();
        System.out.println("\nDuplicates are printed: ");
        permutation.permuteAndPrint(TEXT);

        Set<String> permutations = permutation.permuteAndStore(TEXT);
        System.out.println("\n\nDuplicates are eliminated: ");
        System.out.println(permutations);
    }

}
