package com.telrun.rledenev.dryKissYagni;

import java.util.List;
import java.util.stream.Collectors;

public class DataProcessor {
    public void processData(List<Integer> data) {
        int sum = 0;
        for (int num : data) {
            sum += num;
        }
        System.out.println("Sum: " + sum);

        double average = (double) sum / data.size();
        System.out.println("Average: " + average);
    }

    public void processUserData(List<User> users) {
        List<Integer> userAges = users.stream()
                .map(User::getAge)
                .collect(Collectors.toList());
        processData(userAges);
    }
}
