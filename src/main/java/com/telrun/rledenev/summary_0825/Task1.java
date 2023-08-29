package com.telrun.rledenev.summary_0825;

public class Task1 {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                    System.out.println("message");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("------------");
                }
            }
        });

        thread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread.interrupt();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main is ended!");
    }
}
