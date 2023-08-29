package com.telrun.rledenev.summary_0825;

/**
 * // Требуется создать потокобезопасный класс, который отвечает за счётчик с суммой. Предложите две реализации.
 *     // Методы: increment()/decrement()/getOperationsCount()/getValue()
 */
public class Task2 {
    static class Counter {
        private long sum;
        private int operationCount;

        public synchronized long increment() {
            operationCount++;
            return sum++;
        }

        public synchronized long decrement() {
            operationCount++;
            return sum--;
        }

        public synchronized long getValue() {
            return sum;
        }

        public synchronized int getOperationCount() {
            return operationCount;
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + " " + counter.increment());
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + " " + counter.decrement());
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getValue());
        System.out.println(counter.getOperationCount());
    }
}
