package coding.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams implements Comparator<String> {

    /* Group anagrams via Comparator */
    @Override
    public int compare(String sl, String s2) {
        return sortStringChars(sl).compareTo(sortStringChars(s2));
    }

    /* Group anagrams via Map */
    void printAnagrams(String arr[]) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            // sort the chars of each string
            String anagram = arr[i];
            String sortedAnagram = sortStringChars(anagram);

            if (map.containsKey(sortedAnagram)) {
                map.get(sortedAnagram).add(anagram);
            } else {
                // start a new group of anagrams
                List<String> anagrams = new ArrayList<>();
                anagrams.add(anagram);
                map.put(sortedAnagram, anagrams);
            }
        }

        // print the result
        for (String sortedAnagram : map.keySet()) {
            List<String> anagrams = map.get(sortedAnagram);
            if (anagrams.size() > 1) {
                System.out.print(anagrams);
            }
        }
    }

    // helper method for sorting the chars of a string
    private static String sortStringChars(String str) {

        char[] strToChar = str.toCharArray();
        Arrays.sort(strToChar);
        return String.valueOf(strToChar);
    }
}
