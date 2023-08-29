package com.telrun.rledenev._2023_08_29;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Kitchen {
    private final ExecutorService chefThreadPool; // наши повара

    public Kitchen(int chefCount) {
        chefThreadPool = Executors.newFixedThreadPool(chefCount); // Используем ThreadPool для ограничения количества одновременно работающих поваров.
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
            synchronized (this) {
                this.notifyAll();
            }
        });
    }

    public void shutdown() {
        chefThreadPool.shutdownNow();
    }
}
