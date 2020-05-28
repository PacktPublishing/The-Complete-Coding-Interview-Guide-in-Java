package coding.challenge;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public final class ProducerConsumer {

    private ProducerConsumer() {
        throw new AssertionError("Cannot be instantiated!");
    }

    private static final int MAX_PROD_TIME_MS = 1000;
    private static final int MAX_CONS_TIME_MS = 1000;
    private static final int TIMEOUT_MS = 5000;

    private static final Logger logger = Logger.getLogger(ProducerConsumer.class.getName());

    private static final Random rnd = new Random();
    private static final List<String> queue = new LinkedList<>();

    private static volatile boolean runningProducer;
    private static volatile boolean runningConsumer;
    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();

    private static ExecutorService producerService;
    private static ExecutorService consumerService;

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while (runningProducer) {
                synchronized (queue) {

                    // if the queue is not empty then wait until the consumer finishes
                    while (!queue.isEmpty()) {

                        logger.info("Queue is not empty ...");

                        try {
                            queue.wait();
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                            logger.severe(() -> "Exception: " + ex);
                            break;
                        }
                    }
                }

                //produce (by adding in the queue) and notify the consumer thread
                synchronized (queue) {
                    try {
                        String product = "product-" + rnd.nextInt(1000);
                        Thread.sleep(rnd.nextInt(MAX_PROD_TIME_MS)); // simulate the production time

                        queue.add(product);
                        logger.info(() -> "Produced: " + product);

                        queue.notify();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                        logger.severe(() -> "Exception: " + ex);
                        break;
                    }
                }
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (runningConsumer) {
                synchronized (queue) {

                    // if the queue is empty then wait until the producer produces
                    while (queue.isEmpty()) {

                        logger.info("Queue is empty ...");

                        try {
                            queue.wait();
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                            logger.severe(() -> "Exception: " + ex);
                            break;
                        }
                    }
                }

                // if the queue is not empty then the consumer will consume
                // (by removing from the queue) and notify the producer thread      
                synchronized (queue) {
                    try {

                        String product = queue.remove(0);

                        if (product != null) {
                            Thread.sleep(rnd.nextInt(MAX_CONS_TIME_MS)); // simulate consuming time
                            logger.info(() -> "Consumed: " + product);

                            queue.notify();
                        }

                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                        logger.severe(() -> "Exception: " + ex);
                        break;
                    }
                }
            }

        }
    }

    public static void startProducerConsumer() {

        if (runningProducer || runningConsumer) {
            logger.info("Producer-Consumer already running ...");
            return;
        }

        logger.info("\n\nStarting Producer-Consumer ...");
        queue.clear();

        runningProducer = true;
        producerService = Executors.newSingleThreadExecutor();
        producerService.execute(producer);

        runningConsumer = true;
        consumerService = Executors.newSingleThreadExecutor();
        consumerService.execute(consumer);
    }

    public static void stopProducerConsumer() {

        logger.info("Stopping Producer-Consumer ...");

        boolean isProducerDown = shutdownProducer();
        boolean isConsumerDown = shutdownConsumer();

        if (!isProducerDown || !isConsumerDown) {
            logger.severe("Something abnormal happened during shutting down the Producer-Consumer!");
            System.exit(0);
        }

        logger.info("Producer-Consumer was successfully stopped!");
    }

    private static boolean shutdownProducer() {

        runningProducer = false;
        return shutdownExecutor(producerService);
    }

    private static boolean shutdownConsumer() {

        runningConsumer = false;
        return shutdownExecutor(consumerService);
    }

    private static boolean shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();

                return executor.awaitTermination(TIMEOUT_MS, TimeUnit.MILLISECONDS);
            }

            return true;
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            logger.severe(() -> "Exception: " + ex);
        }
        return false;
    }
}
