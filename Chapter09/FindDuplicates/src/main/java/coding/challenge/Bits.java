package coding.challenge;
 
import java.util.BitSet;

public final class Bits {

    private static final int MAX_N = 32000;

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void printDuplicates(int[] arr) {

        BitSet bitArr = new BitSet(MAX_N);

        for (int i = 0; i < arr.length; i++) {

            int nr = arr[i];
            if (bitArr.get(nr)) {                
                System.out.println("Duplicate: " + nr);
            } else {
                bitArr.set(nr);                
            }
        }
    }
}
