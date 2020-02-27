package coding.challenge;

import java.util.Map;
import java.util.TreeMap;

public final class Arrays {

    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void replace(int[] m) {

        if (m == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        Map<Integer, Integer> treemap = new TreeMap<>();

        // store (element, index) 
        for (int i = 0; i < m.length; i++) {
            treemap.put(m[i], i);
        }

        // rank starts from 1
        int rank = 1;

        // iterate through the map and replace each element by its rank
        for (Map.Entry<Integer, Integer> entry : treemap.entrySet()) {
            m[entry.getValue()] = rank++;
        }
    }

}
