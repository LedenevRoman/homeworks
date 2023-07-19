package com.telrun.rledenev._2023_06_13;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Работа с мапой
public class CT2 {

    /**
     * 1. Найти все ключи в Map<String, Integer>, соответствующие заданному значению, и вернуть их в виде списка.
    */
    public static List<String> findKeys(Map<String, Integer> inputMap, int targetValue) {
         return inputMap.entrySet()
                .stream()
                .filter(stringIntegerEntry -> stringIntegerEntry.getValue().equals(targetValue))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * 2. Проверить, содержит ли Map<String, Integer> хотя бы одну запись, у которой значение больше заданного порога.
     */
    public static boolean hasValueAboveThreshold(Map<String, Integer> inputMap, int threshold) {
        return inputMap.entrySet()
                .stream()
                .anyMatch(stringIntegerEntry -> stringIntegerEntry.getValue() > threshold);
    }

    /**
     * 3.Проверить, все ли значения в Map<Integer, Boolean> равны true.
     *
     */
    public static boolean allValuesTrue(Map<Integer, Boolean> inputMap) {
        return inputMap.entrySet()
                .stream()
                .allMatch(Map.Entry::getValue);
    }

    /**
     * 4. Найти сумму всех значений(int) в Map<String, Integer>, которые соответствуют заданному ключевому набору.
     *
     */
    public static int calculateSum(Map<String, Integer> inputMap, String[] keys) {
        int sum = 0;
        for (String key : keys) {
            if (inputMap.containsKey(key)) {
                sum += inputMap.get(key);
            }
        }
        return sum;
    }

    /**
     * 5.Получить все ключи Map<Integer, Boolean>, у которых значение равно true, и вернуть их в виде списка.
     */
    public static List<Integer> findTrueKeys(Map<Integer, Boolean> inputMap) {
        return inputMap.entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}