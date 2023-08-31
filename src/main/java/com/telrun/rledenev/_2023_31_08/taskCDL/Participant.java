package com.telrun.rledenev._2023_31_08.taskCDL;

import java.util.concurrent.CountDownLatch;

public class Participant implements Runnable {
    private final CountDownLatch countDownLatch;

    public Participant(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + " started");
            Thread.sleep(1500);
            System.out.println(Thread.currentThread().getName() + " finished");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
