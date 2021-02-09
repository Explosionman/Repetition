package ru.rybinskov.gb.task2;

import java.util.concurrent.locks.Lock;

public class LockExample implements Runnable {
    private Counter counter;
    private Lock lock;

    public LockExample(Counter counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }


    @Override
    public void run() {
        lock.lock();
        counter.increment();
        System.out.println(counter.getCount());
        lock.unlock();
    }
}
