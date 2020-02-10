package coding.challenge;

import java.util.List;
import java.util.Set;

public class Main {

    private static final String TEXT = "test";

    public static void main(String[] args) {

        SimplePermutation sp = new SimplePermutation();
        System.out.println("\nDuplicates are printed: ");
        sp.permute(TEXT);

        DuplicatePermutation dp = new DuplicatePermutation();
        Set<String> permutationSet = dp.permute(TEXT);
        System.out.println("\n\nDuplicates are generated but they are eliminated via Set: ");
        System.out.println(permutationSet);

        NoDuplicatePermutation ndp = new NoDuplicatePermutation();
        List<String> permutationList = ndp.permute(TEXT);
        System.out.println("\n\nDuplicates are  not generated: ");
        System.out.println(permutationList);
    }

}
