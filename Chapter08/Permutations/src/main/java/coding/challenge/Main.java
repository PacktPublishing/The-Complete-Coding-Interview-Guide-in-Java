package coding.challenge;
 
import java.util.List;
import java.util.Set;

public class Main {

    private static final String TEXT = "test";

    public static void main(String[] args) {
        
        System.out.println("\nDuplicates are printed: ");
        SimplePermutation.permute(TEXT);
        
        Set<String> permutationSet = DuplicatePermutation.permute(TEXT);
        System.out.println("\n\nDuplicates are generated but they are eliminated via Set: ");
        System.out.println(permutationSet);
      
        List<String> permutationList = NoDuplicatePermutation.permute(TEXT);
        System.out.println("\n\nDuplicates are  not generated: ");
        System.out.println(permutationList);
    }

}
