package ru.rybinskov.gb.task1;

public class Main {
    private static volatile int streamNumber = 1;

    public static void main(String[] args) {
        Object mon = new Object();

        new Thread(() -> {
            synchronized (mon) {
                try {
                    for (int i = 0; i < 50; i++) {
                        while (streamNumber != 1) {
                            mon.wait();
                        }
                        System.out.println("ping");
                        Thread.sleep(2000);
                        streamNumber = 2;
                        mon.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (mon) {
                try {
                    for (int i = 0; i < 50; i++) {
                        while (streamNumber != 2) {
                            mon.wait();
                        }
                        System.out.println("pong");
                        Thread.sleep(2000);
                        streamNumber = 1;
                        mon.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
