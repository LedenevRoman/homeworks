package com.telrun.rledenev.dryKissYagni;

public class Shape {
    private final Type type;
    private final double param;
    private final CA calculator;

    public Shape(Type type, double param, CA calculator) {
        this.type = type;
        this.param = param;
        this.calculator = calculator;
    }

    public double calculateArea() {
        if (type == Type.CIRCLE) {
            return calculator.calculateCircleArea(param);
        } else {
            return calculator.calculateSquareArea(param);
        }
    }
}