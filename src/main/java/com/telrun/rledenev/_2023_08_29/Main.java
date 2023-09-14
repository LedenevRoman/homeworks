package com.telrun.rledenev._2023_08_29;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dish dish1 = new Dish("1", 15000, Status.NEW);
        Dish dish2 = new Dish("2", 2000, Status.NEW);
        Dish dish3 = new Dish("3", 3000, Status.NEW);
        Dish dish4 = new Dish("4", 5000, Status.NEW);
        Dish dish5 = new Dish("5", 4000, Status.NEW);
        Dish dish6 = new Dish("6", 3000, Status.NEW);
        Dish dish7 = new Dish("7", 2000, Status.NEW);
        Dish dish8 = new Dish("8", 1000, Status.NEW);
        Order order1 = new Order("1", List.of(dish1, dish2), Status.NEW);
        Order order2 = new Order("2", List.of(dish3, dish4), Status.NEW);
        Order order3 = new Order("3", List.of(dish5, dish6), Status.NEW);
        Order order4 = new Order("4", List.of(dish7, dish8), Status.NEW);
        Kitchen kitchen = new Kitchen(2);

        OrderProcessor orderProcessor = new OrderProcessor(kitchen);
        Thread thread1 = startNewThread(orderProcessor, order1);
        Thread thread2 = startNewThread(orderProcessor, order2);
        Thread thread3 = startNewThread(orderProcessor, order3);
        Thread thread4 = startNewThread(orderProcessor, order4);

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        kitchen.shutdown();
    }

    private static Thread startNewThread(OrderProcessor orderProcessor, Order order) {
        Thread thread = new Thread(() -> {
            try {
                orderProcessor.processOrder(order);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        thread.start();
        return thread;
    }
}
