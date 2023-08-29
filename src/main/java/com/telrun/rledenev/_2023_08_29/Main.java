package com.telrun.rledenev._2023_08_29;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Dish dish1 = new Dish("Salad", 1000, Status.NEW);
        Dish dish2 = new Dish("Dessert", 2000, Status.NEW);
        Dish dish3 = new Dish("Steak", 3000, Status.NEW);
        Order order1 = new Order("1", List.of(dish1, dish2, dish3), Status.NEW);

        OrderProcessor orderProcessor = new OrderProcessor(new Kitchen(2));
        orderProcessor.processOrder(order1);
    }
}
