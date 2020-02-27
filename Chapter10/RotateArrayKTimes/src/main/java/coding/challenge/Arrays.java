package coding.challenge;

public final class Arrays {

    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void rightRotate(int[] m, int k) {

        int[] cm = m.clone();
        int len = m.length;

        for (int i = 0; i < len; i++) {
            m[(i + k) % len] = cm[i];
        }
    }
}
