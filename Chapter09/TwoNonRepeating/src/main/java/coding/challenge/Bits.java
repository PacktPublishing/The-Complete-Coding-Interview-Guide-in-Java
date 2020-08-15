package coding.challenge;
 
public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void findNonRepeatable(int arr[]) {

        // get the XOR[^] of all elements in the given array
        int xor = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xor ^= arr[i];
        }

        // get the rightmost set bit (you can use any other set bit)
        int setBitNo = xor & ~(xor - 1);

        // divide the elements in two sets by comparing the rightmost set 
        // bit of XOR[^] with the bit at the same position in each element
        int p = 0;
        int q = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & setBitNo) != 0) {
                // xor of the first set
                p = p ^ arr[i];
            } else {
                // xor of the second set
                q = q ^ arr[i];
            }
        }

        System.out.println("The numbers are: " + p + " and " + q);
    }
}
