package com.telrun.rledenev._2023_31_08.taskCDL;

import java.util.concurrent.CountDownLatch;

public class Race {
    private final CountDownLatch countDownLatch;

    public Race(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void countDown() {
        countDownLatch.countDown();
    }
}
