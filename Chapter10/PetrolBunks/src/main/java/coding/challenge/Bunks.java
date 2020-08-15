package coding.challenge;
 
public final class Bunks {

    private Bunks() {
        throw new AssertionError("Cannot be instantiated");
    }
    
    /* O(n) */
    public static int circularTour(int[] fuel, int[] dist) {

        int sumRemainingFuel = 0; // track current remaining fuel
        int totalFuel = 0;        // track total remaining fuel
        int start = 0;

        for (int i = 0; i < fuel.length; i++) {

            int remainingFuel = fuel[i] - dist[i];

            //if sum remaining fuel of (i-1) >= 0 then continue 
            if (sumRemainingFuel >= 0) {
                sumRemainingFuel += remainingFuel;

                //otherwise, reset start index to be current
            } else {
                sumRemainingFuel = remainingFuel;
                start = i;
            }

            totalFuel += remainingFuel;
        }

        if (totalFuel >= 0) {
            return start;
        } else {
            return -1;
        }
    }
}
