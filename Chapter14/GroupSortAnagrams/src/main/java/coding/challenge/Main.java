package coding.challenge;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] words = {
            "calipers", "caret", "slat", "cater", "thickset", "spiracle", "trace",
            "last", "salt", "bowel", "crate", "loop", "polo", "thickest",
            "below", "thickets", "pool", "elbow", "replicas"
        };
        
        Anagrams anagrams = new Anagrams();
        
        System.out.println("\n\nVia hashing: ");
        anagrams.printAnagrams(words);        
  
        System.out.println("\n\nVia Comparator: ");
        Arrays.sort(words, new Anagrams());
        System.out.println(Arrays.toString(words));
    }
}
