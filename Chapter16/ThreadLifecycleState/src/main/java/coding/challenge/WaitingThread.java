package coding.challenge;

// Examples for the WAITING state:

/*
    1. Create a thread: t1.
    2. Start t1 via the start() method.
    3. In the run() method of t1:
        1. Create another thread: t2.
        2. Start t2 via the start() method.
        3. While t2 is running, call t2.join()—since t2 needs to join t1
           (or, in other words, t1 needs to wait for t2 to die), t1 is in the WAITING state.
    4. In the run() method of t2, t2 prints the state of t1, which should be
    WAITING (while printing the t1 state, t2 is running, therefore t1 is waiting).
*/

public class WaitingThread {

    private static final Thread t1 = new CodeT1();

    public void waitingThread() {
        t1.start();
    }

    private static class CodeT1 extends Thread {

        @Override
        public void run() {
            Thread t2 = new Thread(new CodeT2());
            t2.start();

            try {
                t2.join();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                // log ex
            }
        }
    }

    private static class CodeT2 implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                // log ex
            }

            System.out.println("WaitingThread t1: " + t1.getState() + " \n");
        }
    }
}

/*

// Alternative implementation

public void waitingThread() {
        new Thread(() -> {
            Thread t1 = Thread.currentThread();
            Thread t2 = new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("WaitingThread t1: " + t1.getState() + "\n");
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    // log ex
                }
            });
            t2.start();
            try {
                t2.join();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                // log ex
            }
        }).start();
}
*/