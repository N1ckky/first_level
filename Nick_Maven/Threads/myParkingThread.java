package Nick_Maven.Threads;

import java.util.concurrent.Semaphore;


//Разработать консольное многопоточное приложение.
//        Использовать возможности, предоставляемые пакетом java.util.concurrent.
//        Все сущности, желающие получить доступ к ресурсу, должны быть потоками.
//
//2. Автостоянка. Доступно несколько машиномест. На одном месте может находиться только один автомобиль.
//        Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.

public class myParkingThread {
    private static final int PARKING_SLOTS = 5;
    private static final int CAR_AMOUNT = 10;

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(PARKING_SLOTS, true);
        for (int i = 1; i < CAR_AMOUNT + 1; i++) {
            new Parking("Car # " + i, semaphore).start();
        }
    }
}

