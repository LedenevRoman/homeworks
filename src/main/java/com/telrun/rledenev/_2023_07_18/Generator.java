package com.telrun.rledenev._2023_07_18;

import com.github.javafaker.Faker;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Generator {
    private static final Faker FAKER = new Faker();

    public Developer generateDeveloper() {
        String name = FAKER.name().firstName();
        String lastName = FAKER.name().lastName();
        int age = FAKER.random().nextInt(18, 70);
        BigDecimal salary = BigDecimal.valueOf(FAKER.random().nextDouble() * 3000 + 2000)
                .setScale(2, RoundingMode.HALF_UP);
        char gender = FAKER.random().nextBoolean() ? 'm' : 'f';
        Car car = generateCar();
        return new Developer(name, lastName, age, salary, gender, car);
    }

    private Car generateCar() {
        String color = FAKER.color().name();
        boolean isSportCar = false;
        int maxSpeed = FAKER.random().nextInt(150, 450);
        if (maxSpeed >= 300) {
            isSportCar = true;
        }
        Brand[] brands = Brand.values();
        Brand brand = brands[FAKER.random().nextInt(brands.length)];
        return new Car(color, isSportCar, brand, maxSpeed);
    }
}
