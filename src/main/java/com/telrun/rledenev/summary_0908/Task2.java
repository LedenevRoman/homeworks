package com.telrun.rledenev.summary_0908;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Task2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TypeProcessor typeProcessor = new TypeProcessor(2);

        typeProcessor.configureProcess(Car.class, car -> {
            System.out.println("car = " + Thread.currentThread().getName() + " " + car);
        });

        typeProcessor.configureProcess(Dog.class, dog -> {
            System.out.println("dog = " + Thread.currentThread().getName() + " " + dog);
            //throw new RuntimeException();
        });

        Dog dog = new Dog();
        Car car = new Car();

        Future<Void> taskResult = typeProcessor.runProcessAsync(dog); // запускает задачу асинхронно

        taskResult.get();

        typeProcessor.runSync(car); // запускает задачу в текущем потоке*/

        typeProcessor.serviceShutdown();
        Thread.sleep(2000);
    }
}
