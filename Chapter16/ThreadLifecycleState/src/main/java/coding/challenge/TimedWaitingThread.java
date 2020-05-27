package coding.challenge;

// Scenario for the TIME_WAITING state:

/*
    1. Create a thread: t1.
    2. Start t1 via the start() method.
    3. In the run() method of t1, add a sleep time of two seconds (arbitrary time).
    4. While t1 is running, the main thread prints the t1 state - the state should
       be TIMED_WAITING since t1 is in a sleep() that will expire after two seconds.
*/

public class TimedWaitingThread {

    public void timedWaitingThread() {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                // log ex
            }
        });
        t.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            // log ex
        }
        
        System.out.println("TimedWaitingThread t: " + t.getState() + "\n");
    }
}
