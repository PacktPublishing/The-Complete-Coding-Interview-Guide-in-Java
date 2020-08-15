package coding.challenge;
 
// Time Complexity : O(nz), z-the longest word from the dictionary
// Space Complexity : O(space of the trie + str.length)
public class Trie {

    private static final int CHAR_SIZE = 26; // characters 'a'-'z'

    private final Node head;

    public Trie() {
        this.head = new Node();
    }

    // Trie node
    private static class Node {

        private boolean leaf;
        private final Node[] next;

        private Node() {
            this.leaf = false;
            this.next = new Node[CHAR_SIZE];
        }
    };

    // insert a string in Trie
    public void insertTrie(String str) {

        if (str == null) {
            throw new IllegalArgumentException("The given string cannot be null");
        }

        Node node = head;

        for (int i = 0; i < str.length(); i++) {
            if (node.next[str.charAt(i) - 'a'] == null) {
                node.next[str.charAt(i) - 'a'] = new Node();
            }

            node = node.next[str.charAt(i) - 'a'];
        }

        node.leaf = true;
    }

    // Method to determine if the given string can be segmented into a
    // space-separated sequence of one or more dictionary words
    public boolean breakIt(String str) {

        // table[i] is true if the first i 
        // characters of str can be segmented
        boolean[] table = new boolean[str.length() + 1];
        table[0] = true;

        for (int i = 0; i < str.length(); i++) {

            if (table[i]) {
                Node node = head;
                for (int j = i; j < str.length(); j++) {

                    if (node == null) {
                        break;
                    }

                    node = node.next[str.charAt(j) - 'a'];

                    // [0, i]: use our known decomposition
                    // [i+1, j]: use this String in the Trie
                    if (node != null && node.leaf) {
                        table[j + 1] = true;
                    }
                }
            }
        }

        // table[n] would be true if all characters of str can be segmented
        return table[str.length()];
    }
}
