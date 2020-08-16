package coding.challenge;
 
public final class Abcd {

    private Abcd() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void find() {
        for (int i = 1000; i < 2499; i++) {

            int p = i;
            int q = i * 4;

            String m = String.valueOf(p);
            String n = new StringBuilder(String.valueOf(q)).reverse().toString();

            p = Integer.parseInt(m);
            q = Integer.parseInt(n);

            if (p == q) {
                System.out.println("\n\nFound: " + p + " : " + (q * 4));
                break;
            }
        }
    }
}
