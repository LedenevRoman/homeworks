package com.telrun.rledenev._2023_08_29;

import java.util.List;

class OrderProcessor {
    private final Kitchen kitchen;
    private final Object lock;

    public OrderProcessor(Kitchen kitchen, Object lock) {
        this.kitchen = kitchen;
        this.lock = lock;
    }

    public void processOrder(Order order) throws InterruptedException {
        List<Dish> dishList = order.getDishes();
        order.setStatus(Status.COOKING);
        for (Dish dish : dishList) {
            kitchen.cookDish(dish);
        }
        synchronized (lock) {
            while (dishList.stream()
                    .anyMatch(d -> !d.getStatusDish().equals(Status.READY))) {
                lock.wait();
            }
            order.setStatus(Status.READY);
            System.out.println("READY" + order.getId());
        }
        kitchen.shutdown();
    }
}
