package coding.challenge;

public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }
        
    public static void swap(int p, int q) {
        
        System.out.println();
        System.out.println("Before swap: p=" + p + ", q=" + q);
        p = p ^ q ^ (q = p);
        System.out.println("After swap: p=" + p + ", q=" + q);
    }
}
