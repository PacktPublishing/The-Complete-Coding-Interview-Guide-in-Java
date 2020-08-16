package coding.challenge;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams implements Comparator<String> {

    // this can be increased for supporting more characters
    private final static int RANGE_a_z = 26;

    /* Group anagrams via Comparator */
    @Override
    public int compare(String wordl, String word2) {
        return sortWordChars(wordl).compareTo(sortWordChars(word2));
    }

    /* Group anagrams via hashing (O(nm log m) */
    public void printAnagrams(String words[]) {

        Map<String, List<String>> result = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            // sort the chars of each string
            String word = words[i];
            String sortedWord = sortWordChars(word);

            if (result.containsKey(sortedWord)) {
                result.get(sortedWord).add(word);
            } else {
                // start a new group of anagrams
                List<String> anagrams = new ArrayList<>();
                anagrams.add(word);
                result.put(sortedWord, anagrams);
            }
        }

        // print the result
        System.out.println(result.values());
    }

    /* Group anagrams via hashing (O(nm) */
    public void printAnagramsOptimized(String[] words) {

        Map<String, List<String>> result = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            char[] wordToChar = new char[RANGE_a_z];

            // count up the number of occurrences (frequency) of each letter in 'word'
            for (int j = 0; j < word.length(); j++) {
                wordToChar[word.charAt(j) - 'a']++;
            }

            String computedWord = String.valueOf(wordToChar);

            if (result.containsKey(computedWord)) {
                result.get(computedWord).add(word);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(word);
                result.put(computedWord, anagrams);
            }
        }

        System.out.println(result.values());
    }

    // helper method for sorting the chars of a word
    private static String sortWordChars(String word) {

        char[] wordToChar = word.toCharArray();
        Arrays.sort(wordToChar);
        
        return String.valueOf(wordToChar);
    }
}
