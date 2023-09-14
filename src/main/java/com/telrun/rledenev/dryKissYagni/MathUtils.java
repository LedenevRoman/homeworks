package com.telrun.rledenev.dryKissYagni;

import java.util.List;

public class MathUtils {
    public static int calculateSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
    
    public static int calculateSum(List<Integer> numbers) {
        return calculateSum(numbers.stream()
                .mapToInt(n -> n)
                .toArray());
    }
}