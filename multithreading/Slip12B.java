//show lifecycle of thread.program should also print a random sleep timer of the thread.
import java.util.Random;

public class Slip12B implements Runnable {
    private final String threadName;
    private final Random random = new Random();

    public Slip12B(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Baka " + threadName + " has been created.");

        int sleepTime = random.nextInt(5000);
        System.out.println("Thread " + threadName + " sleeping for " + sleepTime + "ms.");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
            return;
        }

        System.out.println(threadName + " has Shinayed.");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Slip12B("Thread 1"));
        Thread thread2 = new Thread(new Slip12B("Thread 2"));
        Thread thread3 = new Thread(new Slip12B("Thread 3"));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

