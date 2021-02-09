package ru.rybinskov.gb.task2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new LockExample(counter, lock));
            thread.start();
        }
    }
}
