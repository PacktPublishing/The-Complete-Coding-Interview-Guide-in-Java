package coding.challenge;
 
public final class Elevators {

    private Elevators() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int time(int k, int floors[]) {

        if (floors == null || floors.length == 0 || k <= 0) {
            return -1;
        }

        int aux;
        for (int i = 0; i < floors.length - 1; i++) {
            for (int j = i + 1; j < floors.length; j++) {
                if (floors[i] < floors[j]) {
                    aux = floors[i];
                    floors[i] = floors[j];
                    floors[j] = aux;
                }
            }
        }

        // iterate the groups and update the time needed for each group 
        int time = 0;
        for (int i = 0; i < floors.length; i += k) {
            time += (2 * floors[i]);
        }

        return time;
    }
}
