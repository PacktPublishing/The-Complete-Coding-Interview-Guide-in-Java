package coding.challenge;

public class SimpleThreadPoolExecutor implements Runnable {

    private final int taskId;

    public SimpleThreadPoolExecutor(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            // log ex
        }
        System.out.println("Executing task " + taskId + " via " + Thread.currentThread().getName());
    }

    public int getTaskId() {
        return taskId;
    }        
}
