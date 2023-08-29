package com.telrun.rledenev._2023_08_23_MT;

public class Main {
    public static void main(String[] args) {
        SumNumbersInRange sumNumbersInRange1 = new SumNumbersInRange(1, 2500);
        SumNumbersInRange sumNumbersInRange2 = new SumNumbersInRange(2501, 5000);
        SumNumbersInRange sumNumbersInRange3 = new SumNumbersInRange(5001, 7500);
        SumNumbersInRange sumNumbersInRange4 = new SumNumbersInRange(7501, 10000);

        Thread thread1 = new Thread(sumNumbersInRange1);
        Thread thread2 = new Thread(sumNumbersInRange2);
        Thread thread3 = new Thread(sumNumbersInRange3);
        Thread thread4 = new Thread(sumNumbersInRange4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(sumNumbersInRange1.getSum() + sumNumbersInRange2.getSum()
                + sumNumbersInRange3.getSum() + sumNumbersInRange4.getSum());
    }
}
