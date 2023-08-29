package com.telrun.rledenev._2023_08_29;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Kitchen {
    private final ExecutorService chefThreadPool; // наши повара
    private final Object lock;

    public Kitchen(int chefCount, Object lock) {
        chefThreadPool = Executors.newFixedThreadPool(chefCount); // Используем ThreadPool для ограничения количества одновременно работающих поваров.
        this.lock = lock;
    }

    public void cookDish(Dish dish) {
        chefThreadPool.execute(() -> {
            System.out.println("cooking: " + dish.getName() + " with thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(dish.getPreparationTime());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(dish.getName() + "The process was interrupted");
            }
            dish.setStatusDish(Status.READY);
            System.out.println(dish.getName() + " is ready!");
            synchronized (lock) {
                lock.notifyAll();
            }
        });
    }

    public void shutdown() {
        chefThreadPool.shutdownNow();
    }
}
