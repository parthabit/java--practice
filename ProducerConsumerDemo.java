import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    private Queue<Integer> buffer = new LinkedList<>();
    private final int CAPACITY;

    public SharedBuffer(int capacity) {
        this.CAPACITY = capacity;
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (buffer.size() == CAPACITY) {
            System.out.println("Buffer full. Producer waiting...");
            wait(); // wait until consumer consumes
        }
        buffer.add(item);
        System.out.println("Produced: " + item);
        notifyAll(); // notify consumers
    }

    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("Buffer empty. Consumer waiting...");
            wait(); // wait until producer produces
        }
        int item = buffer.poll();
        System.out.println("Consumed: " + item);
        notifyAll(); // notify producers
        return item;
    }
}

class Producer implements Runnable {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int item = 0;
        try {
            while (true) {
                buffer.produce(item++);
                Thread.sleep(500); // simulate production time
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.consume();
                Thread.sleep(1000); // simulate consumption time
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5);

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }
}
