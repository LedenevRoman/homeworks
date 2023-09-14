package com.telrun.rledenev.dryKissYagni;


import lombok.Getter;

@Getter
public class CircleQ {
    private final double radius;

    public CircleQ(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
}
