package com.telrun.rledenev.dryKissYagni;

import java.util.List;

public class D1 {
    public double calculateAverage(List<Double> listOfNumbers) {
        return listOfNumbers.stream()
                .mapToDouble(n -> n)
                .average()
                .orElse(0.0);
    }
}

