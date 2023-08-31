package com.telrun.rledenev._2023_08_29;

import java.util.List;

class OrderProcessor {
    private final Kitchen kitchen;

    public OrderProcessor(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public void processOrder(Order order) throws InterruptedException {
        List<Dish> dishList = order.getDishes();
        order.setStatus(Status.COOKING);
        for (Dish dish : dishList) {
            kitchen.cookDish(dish);
        }
        synchronized (kitchen) {
            while (dishList.stream()
                    .anyMatch(d -> !d.getStatusDish().equals(Status.READY))) {
                kitchen.wait();
            }
        }
        order.setStatus(Status.READY);
        System.out.println("ORDER-" + order.getId() + " IS READY");
    }
}
