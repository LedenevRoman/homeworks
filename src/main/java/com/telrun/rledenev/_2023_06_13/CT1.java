package com.telrun.rledenev._2023_06_13;

import java.util.*;

//Перебор коллекций
public class CT1 {
    public static void main(String[] args) {
        List<String> duplicateStrings = List.of("AAA", "BBB", "AAA", "CCC", "DDD", "BBB", "EEE", "DDD");
        System.out.println(findDup(duplicateStrings));
        System.out.println(findStringInList("EEE", duplicateStrings));

        Set<Integer> integers = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(getSumOfEvenNumbers(integers));
        System.out.println(isAnyStringStatsWithPrefix(duplicateStrings, "YY"));
        System.out.println(getCombinationsOfStringInteger(duplicateStrings, integers));

    }

    //Найти все дубликаты в List<String> и вернуть их в виде нового списка.
    public static List<String> findDup(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        for (String string : list) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }

        List<String> duplicates = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return duplicates;
    }


    //Проверить, содержит ли List<String> заданную строку
    // и вернуть ее индекс. Если строка не найдена, вернуть -1.

    public static int findStringInList(String string, List<String> list) {
        return list.indexOf(string);
    }


    //Найти сумму всех элементов в Set<Integer>, которые являются четными числами.
    public static int getSumOfEvenNumbers(Set<Integer> integers) {
        int sum = 0;
        for (Integer i : integers) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }


    //Проверить, содержит ли List<String> хотя бы
    // одну строку, которая начинается с заданного префикса.
    public static boolean isAnyStringStatsWithPrefix(List<String> list, String prefix) {
        return list.stream().anyMatch(s -> s.startsWith(prefix));
    }


    //Получить все возможные комбинации из List<String> и Set<Integer>,
    //где каждая комбинация представляет собой строку и число, объединенные вместе.
    public static List<String> getCombinationsOfStringInteger(List<String> list, Set<Integer> set) {
        List<String> result = new ArrayList<>();
        for (Integer tempInt : set) {
            for (String string : list) {
                result.add(string + tempInt.toString());
            }
        }
        return result;
    }
}
