package coding.challenge;

public final class Hanoi {

    private Hanoi() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void moveDisks(int n, char origin, char target, char intermediate) {       
        
        if (n <= 0) {
            return;
        }

        if (n == 1) {
            System.out.println("Move disk 1 from rod " + origin + " to rod " + target);
            return;
        }

        // move top n - 1 disks from origin to intermediate, using target as a intermediate
        moveDisks(n - 1, origin, intermediate, target);

        System.out.println("Move disk " + n + " from rod " + origin + " to rod " + target);

        // move top n - 1 disks from intermediate to target, using origin as an intermediate
        moveDisks(n - 1, intermediate, target, origin);
    }
}
