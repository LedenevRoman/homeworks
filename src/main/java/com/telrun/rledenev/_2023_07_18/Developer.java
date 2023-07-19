package com.telrun.rledenev._2023_07_18;

import java.math.BigDecimal;
import java.util.Objects;

public class Developer {
    private final String name;
    private final String lastName;
    private int age;
    private BigDecimal salary;
    private char gender;
    private Car car;

    public Developer(String name, String lastName, int age, BigDecimal salary, char gender, Car car) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.gender = Character.toLowerCase(gender);
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Developer)) return false;
        Developer developer = (Developer) o;
        return age == developer.age
                && gender == developer.gender
                && Objects.equals(name, developer.name)
                && Objects.equals(lastName, developer.lastName)
                && Objects.equals(salary, developer.salary)
                && Objects.equals(car, developer.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, age, salary, gender, car);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                ", car=" + car +
                '}';
    }
}
