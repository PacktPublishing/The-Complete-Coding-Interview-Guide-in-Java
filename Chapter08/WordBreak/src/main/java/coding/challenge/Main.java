package coding.challenge;
 
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<String> dictionary = new HashSet<>();

        dictionary.add("this");
        dictionary.add("th");
        dictionary.add("is");
        dictionary.add("a");
        dictionary.add("famous");
        dictionary.add("f");
        dictionary.add("a");
        dictionary.add("m");
        dictionary.add("o");
        dictionary.add("u");
        dictionary.add("s");
        dictionary.add("problem");        

        String str1 = "thisisafamousproblem";
        String str2 = "thisisnotafamousproblem";

        System.out.println("str1 can be segmented (plain recursion)? "
                + Words.breakItPlainRecursive(dictionary, str1));
        System.out.println("str2 can be segmented (plain recursion)? "
                + Words.breakItPlainRecursive(dictionary, str2));
        
        System.out.println("str1 can be segmented (bottom up)? "
                + Words.breakItBottomUp(dictionary, str1));
        System.out.println("str2 can be segmented (bottom up)? "
                + Words.breakItBottomUp(dictionary, str2));
      
        Trie trie = new Trie();
        trie.insertTrie("this");
        trie.insertTrie("th");
        trie.insertTrie("is");
        trie.insertTrie("a");
        trie.insertTrie("famous");
        trie.insertTrie("f");
        trie.insertTrie("a");
        trie.insertTrie("m");
        trie.insertTrie("o");
        trie.insertTrie("u");
        trie.insertTrie("s");
        trie.insertTrie("problem");        
        System.out.println("str1 can be segmented (trie)? "
                + trie.breakIt(str1));
        System.out.println("str2 can be segmented (trie)? "
                + trie.breakIt(str2));
        
        System.out.println();
        Words.printAllSequences(dictionary, str1, "");
        System.out.println();
        Words.printAllSequences(dictionary, str2, "");
    }

}
