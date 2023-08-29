package com.telrun.rledenev._2023_08_23_MT;

import lombok.Getter;

public class SumNumbersInRange implements Runnable {
    private final int lowRange;
    private final int topRange;
    @Getter
    private int sum;

    public SumNumbersInRange(int lowRange, int topRange) {
        this.lowRange = lowRange;
        this.topRange = topRange;
    }

    @Override
    public void run() {
        for (int i = lowRange; i <= topRange ; i++) {
            sum = sum + i;
        }
    }
}
