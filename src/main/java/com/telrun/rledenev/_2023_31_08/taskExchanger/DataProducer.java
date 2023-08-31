package com.telrun.rledenev._2023_31_08.taskExchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class DataProducer implements Runnable {
    private static final Random RANDOM = new Random();
    private final Exchanger<Integer> exchanger;

    public DataProducer(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    public int getRandomNumberAbove100() {
        return RANDOM.nextInt(100);
    }

    @Override
    public void run() {
        try {
            int number = getRandomNumberAbove100();
            exchanger.exchange(number);
            Integer sqrNumber = exchanger.exchange(null);
            System.out.println("Square of " + number + " is " + sqrNumber);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
