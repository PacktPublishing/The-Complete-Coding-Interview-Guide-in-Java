package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int[] sequence = {4, 2, 9, 5, 12, 6, 8};

        int longestSequence = Sequences.findLongestConsecutive(sequence);
        System.out.println("Longest sequence has " + longestSequence + " element(s)");
    }

}
