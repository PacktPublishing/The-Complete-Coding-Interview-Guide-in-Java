package coding.challenge;

// Scenario for the TERMINATED state:

/* 
    The main thread of the application prints the state of the thread, t.
    When this is happening, the thread, t, has done its job.
*/

public class TerminatedThread {

    public void terminatedThread() {
        
        Thread t = new Thread(() -> {            
        });
        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            // log ex
        }
        
        System.out.println("TerminatedThread t: " + t.getState() + "\n");
    }
}
