package coding.challenge;
 
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Sequences {

    private Sequences() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int findLongestConsecutive(int[] sequence) {

        if (sequence == null) {
            throw new IllegalArgumentException("The given sequence cannot be empty");
        }

        // construct a set from the given sequence
        Set<Integer> sequenceSet = IntStream.of(sequence)
                .boxed()
                .collect(Collectors.toSet());

        int longestSequence = 1;

        for (int elem : sequence) {

            // if 'elem-1' is not in the set then start a new sequence
            if (!sequenceSet.contains(elem - 1)) {

                int sequenceLength = 1;

                // lookup in the set for elements 'elem + 1', 'elem + 2', 'elem + 3' ...
                while (sequenceSet.contains(elem + sequenceLength)) {
                    sequenceLength++;
                }

                // update the longest consecutive subsequence
                longestSequence = Math.max(longestSequence, sequenceLength);
            }
        }

        return longestSequence;
    }
}
