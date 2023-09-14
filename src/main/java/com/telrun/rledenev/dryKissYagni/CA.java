package com.telrun.rledenev.dryKissYagni;

public class CA {
    public double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public double calculateSquareArea(double side) {
        return side * side;
    }

    public double calculateTriangleArea(double sideA, double sideB, double sideC) {
        double semiPerimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));
    }
}