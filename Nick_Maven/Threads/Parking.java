package Nick_Maven.Threads;

import java.util.concurrent.Semaphore;

public class Parking extends Thread {
    private static final int WAIT_TIME = 2500;
    private static final int PARKING_TIME = 1500;
    private static final int ZERO = 0;

    Parking(String name, Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }

    private Semaphore semaphore;

    private void checkSlots() throws InterruptedException {
        if (semaphore.availablePermits() == ZERO) {
            System.out.println(Thread.currentThread().getName() + " is in queue. Waiting for free parking place");
            sleep(WAIT_TIME);
            if (semaphore.availablePermits() == ZERO) {
                throw new InterruptedException();
            }
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " try to parking");
        try {
            checkSlots();
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " parked");
            sleep(PARKING_TIME);
            System.out.println(Thread.currentThread().getName() + " leave parking place");
            semaphore.release();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " can't parking. So it leave parking");
            Thread.currentThread().interrupt();
        }
    }
}

