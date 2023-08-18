package com.telrun.rledenev.summary_0818.task1;

import java.util.ArrayList;
import java.util.List;

public final class EvenOddTask {
    private EvenOddTask() {
    }
    public static EvenAndOddLists getEvenOddList(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        numbers.forEach(num -> {
            if (num != null) {
                if (num % 2 == 0) {
                    even.add(num);
                } else {
                    odd.add(num);
                }
            }
        });
        return new EvenAndOddLists(even, odd);
    }
}
