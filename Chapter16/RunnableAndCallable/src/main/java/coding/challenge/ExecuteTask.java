package coding.challenge;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class ExecuteTask {

    private static final Logger logger = Logger.getLogger(ExecuteTask.class.getName());

    public void runnableExample() {

        // Runnable example
        Thread t = new Thread(() -> {            
            System.out.println("Entered Runnable");
            
            // Perform some computation
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                logger.severe(() -> "Exception: " + ex);
            }
            
            System.out.println("Hello from Runnable");
        });
        t.start();       
    }
    
    public void callableExample() throws InterruptedException, ExecutionException {
        
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {
            
            System.out.println("Entered Callable");
            
            // Perform some computation
            Thread.sleep(2000);
            
            return "Hello from Callable";
        };

        System.out.println("Submitting Callable");
        Future<String> future = executorService.submit(callable);

        // This line executes immediately
        System.out.println("Do something else while callable is getting executed");

        System.out.println("Retrieve the result of the future");
        
        // Future.get() blocks until the result is available
        String result = future.get();
        
        System.out.println(result);

        executorService.shutdown();
    }
}
