package coding.challenge;

// Scenario for the BLOCKED state:

/*
    1) Create two threads: t1 and t2.
    2) Start t1 via the start() method:
        1) t1 will execute the run() method and will acquire the lock for
           the synchronized method, syncMethod().
        2) The syncMethod() will keep t1 inside forever, since it has an
           infinite loop.
    3) After two seconds (arbitrary time), start t2 via the start() method:
        1) t2 will execute the run() code and will end up in the
        BLOCKED state since it cannot acquire the lock of syncMethod().
*/

public class BlockedThread {

    public void blockedThread() {
        Thread t1 = new Thread(new SyncBlockCode());
        Thread t2 = new Thread(new SyncBlockCode());

        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            // log ex
        }
        t2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            // log ex
        }

        System.out.println("Blocked thread t1: " 
                + t1.getState() + "(" + t1.getName() + ")");
        System.out.println("Blocked thread t2: " 
                + t2.getState() + "(" + t2.getName() + ")");

        System.exit(0);
    }

    private static class SyncBlockCode implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread " 
                    + Thread.currentThread().getName() + " is in run() method");
            syncMethod();
        }

        public static synchronized void syncMethod() {
            System.out.println("Thread " 
                    + Thread.currentThread().getName() + " is in syncMethod() method");
            while (true) {
                // t1 will stay here forever, therefore t2 is blocked                
            }
        }
    }
}
