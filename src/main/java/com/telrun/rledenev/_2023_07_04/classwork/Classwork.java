package com.telrun.rledenev._2023_07_04.classwork;

import java.util.List;
import java.util.stream.Collectors;

public class Classwork {
    public static void main(String[] args) {
        System.out.println(getString(List.of(1, 2, 3, 4, 5)));

    }

    // Задача 5: Преобразование чисел в строки и объединение их с разделителем

    public static String getString(List<Integer> integers) {
        return integers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    // Задача 6: Поиск первого четного числа
    public static Integer getFirstPositive(List<Integer> integers) {
        return integers.stream()
                .filter(integer -> integer % 2 == 0)
                .findFirst()
                .orElse(null);
    }

    // Задача 7: Проверка, все ли строки начинаются с буквы "A"
    public static boolean isStartsWithA(List<String> strings) {
        return strings.stream()
                .allMatch(s -> s.toUpperCase().startsWith("A"));
    }

    // Задача 8: Пропуск первых 3 чисел и сумма оставшихся
    public static int getSum(List<Integer> integers) {
        return integers.stream()
                .skip(3)
                .mapToInt(i -> i)
                .sum();
    }

// Задача 9: Выбор минимального и максимального числа из листа
// Задача 10: Группировка слов по длине
// Задача 11: Подсчет среднего значения чисел
// Задача 12: Поиск всех слов, содержащих букву "a"
// Задача 13: Преобразование чисел в квадрат и сортировка в обратном порядке
// Задача 14: Преобразование чисел в двоичный формат и объединение в строку
// Задача 15: Фильтрация чисел, кратных 3, и преобразование их в строки
}
