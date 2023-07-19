package com.telrun.rledenev._2023_07_18;

import java.util.Objects;

public class Car {
    private final String color;
    private final boolean isSportCar;
    private final Brand brand;
    private final int maxSpeed;

    public Car(String color, boolean isSportCar, Brand brand, int maxSpeed) {
        this.color = color;
        this.isSportCar = isSportCar;
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public boolean isSportCar() {
        return isSportCar;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return isSportCar == car.isSportCar && maxSpeed == car.maxSpeed && Objects.equals(color, car.color) && brand == car.brand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, isSportCar, brand, maxSpeed);
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", isSportCar=" + isSportCar +
                ", brand=" + brand +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
