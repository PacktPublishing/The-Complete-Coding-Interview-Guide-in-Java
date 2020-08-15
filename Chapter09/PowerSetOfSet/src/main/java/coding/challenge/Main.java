package coding.challenge;
 
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        char[] set = {'a', 'b', 'c'};
        
        Set<Set<Character>> subsets = Sets.powerSet(set);
        
        System.out.println("Result: " + subsets);
    }

}
