package coding.challenge;

public class Main {
    
    /*
      Pay attention that this code leads to a deadlock !!!
    */

    static class FirstThread implements Runnable {

        @Override
        public void run() {
            synchronized (Double.class) {
                System.out.println("Double.class locked by " + Thread.currentThread().getName());
                synchronized (Float.class) {
                    System.out.println("Float.class locked by " + Thread.currentThread().getName());
                }
            }
        }
    }

    static class SecondThread implements Runnable {

        @Override
        public void run() {
            synchronized (Float.class) {
                System.out.println("Float.class locked by " + Thread.currentThread().getName());
                synchronized (Double.class) {
                    System.out.println("Double.class locked by " + Thread.currentThread().getName());
                }
            }
        }

    }

    public static void main(String[] args) {
        new Thread(new FirstThread(), "First-thread").start();
        new Thread(new SecondThread(), "Second-thread").start();
    }
}
