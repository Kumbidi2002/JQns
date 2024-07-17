class SharedResource {
    private int data;
    private boolean isDataAvailable = false;

    // Method for the producer to produce data
    public synchronized void produce(int value) throws InterruptedException {
        while (isDataAvailable) {
            wait();  // Wait if data is already available
        }
        data = value;
        isDataAvailable = true;
        System.out.println("Produced: " + data);
        notify();  // Notify the consumer that data is available
    }

    // Method for the consumer to consume data
    public synchronized void consume() throws InterruptedException {
        while (!isDataAvailable) {
            wait();  // Wait if no data is available
        }
        System.out.println("Consumed: " + data);
        isDataAvailable = false;
        notify();  // Notify the producer that data has been consumed
    }
}

class Producer implements Runnable {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i <5; i++) {
            try {
                resource.produce(i);
                Thread.sleep(100);  // Simulate time taken to produce data
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                resource.consume();
                Thread.sleep(150);  // Simulate time taken to consume data
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class SharedExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();
    }
}
