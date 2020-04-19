package coding.challenge;

import java.util.Map;
import java.util.TreeMap;

public final class Sorts {

    private Sorts() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void custom(int[] firstArr, int[] secondArr) {

        if (firstArr == null || secondArr == null) {
            throw new IllegalArgumentException("The given input cannot be null");
        }

        // store the frequency of each element of first array
        // using a TreeMap stores the data sorted
        Map<Integer, Integer> frequencyMap = new TreeMap<>();

        for (int i = 0; i < firstArr.length; i++) {
            frequencyMap.putIfAbsent(firstArr[i], 0);
            frequencyMap.put(firstArr[i], frequencyMap.get(firstArr[i]) + 1);
        }

        // overwrite elements of first array
        int index = 0;

        for (int i = 0; i < secondArr.length; i++) {

            // if the current element is present in the 'frequencyMap'
            // then set it n times (n is the frequency of that element in the first array)
            int n = frequencyMap.getOrDefault(secondArr[i], 0);
            while (n-- > 0) {
                firstArr[index++] = secondArr[i];
            }

            // remove the element from map
            frequencyMap.remove(secondArr[i]);
        }

        // copy the remaining elements (the elements that are
        // present in the first array but not present in the second array)        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {

            int count = entry.getValue();

            while (count-- > 0) {
                firstArr[index++] = entry.getKey();
            }
        }
    }
}
