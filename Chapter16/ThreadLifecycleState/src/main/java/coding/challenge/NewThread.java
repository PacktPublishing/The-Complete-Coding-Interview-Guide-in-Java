package coding.challenge;

// Examples for the NEW state:

/*
    The below code contains 4 snippets of
    code that reveal the NEW state via different 
    construction techniques, including lambdas.
*/
        
public class NewThread {

    public void newThread() {

        // construction 1
        Thread t1 = new Thread(() -> {
        });               
        System.out.println("New thread t1: " + t1.getState());

        // construction 2
        Runnable runnable1 = () -> {
        };        
        Thread t2 = new Thread(runnable1);
        System.out.println("New thread t2: " + t2.getState());

        // construction 3
        Thread t3 = new Thread(new Runnable() {
            
            @Override
            public void run() {
            }
        });
        System.out.println("New thread t3: " + t3.getState());
        
        // construction 4
        Thread t4 = new Thread(new Thread() {
            
            @Override
            public void run() {
            }
        });
        System.out.println("New thread t4: " + t4.getState() + "\n");
    }
}
