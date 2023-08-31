package com.telrun.rledenev._2023_31_08.taskExchanger;

import java.util.concurrent.Exchanger;

public class DataProcessor implements Runnable {
    private final Exchanger<Integer> exchanger;

    public DataProcessor(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            Integer number = exchanger.exchange(null);
            Integer sqrNumber = number * number;
            exchanger.exchange(sqrNumber);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
