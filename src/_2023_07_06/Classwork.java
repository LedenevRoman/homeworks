package _2023_07_06;

import _2023_07_13.homework.Homework;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Classwork {
    public static void main(String[] args) {
        Homework.writeArrayToFile();

        //Задача 1: Подсчет количества уникальных четных и нечетных чисел
        List<Integer> numbers = Homework.readIntegersFromFile();
        System.out.println(numbers.stream()
                .distinct()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd", Collectors.counting())));

        //Задача 2: Группировка строк по первым буквам и вывод первых двух из каждой группы
        List<String> words = Homework.readWordsFromFile();
        Map<Character, List<String>> collect = words.stream()
                .collect(Collectors.groupingBy(n -> n.toLowerCase().charAt(0)));
        collect.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value.stream().limit(2).collect(Collectors.toList())));

        //Задача 5: Разделение чисел на простые и составные
        List<Integer> numbers3 = Homework.readIntegersFromFile();
        Map<Boolean, List<Integer>> result = numbers3.stream()
                .collect(Collectors.partitioningBy(Classwork::isPrime));
        System.out.println(result);


        //Задача 6: Получение уникальных символов из списка строк
        List<String> words2 = Homework.readWordsFromFile();
        List<Character> result2 = words2.stream()
                .flatMapToInt(String::chars)
                .mapToObj(ch -> (char) ch)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result2);


        //Задача 7: Разделение строк на отдельные слова и удаление повторений
        List<String> sentences = Homework.readLinesFromFile();
        List<String> result3 = sentences.stream()
                .flatMap(string -> Arrays.stream(string.toLowerCase().split("[,.\\s!?;\"]")))
                .distinct()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
        System.out.println(result3);


        //Задача 8: Фильтрация и преобразование строк toUpperCase
        List<String> words3 = Homework.readWordsFromFile();
        System.out.println(words3.stream()
                .filter(str -> str.length() >= 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList()));

        //Задача 9: Получение среднего значения чисел
        List<Integer> numbers4 = Homework.readIntegersFromFile();
        System.out.println(numbers4.stream()
                .mapToInt(Integer::valueOf)
                .average()
                .orElse(0.0));
        //Задача 10: Получение списка квадратов чисел
        List<Integer> numbers5 = Homework.readIntegersFromFile();
        System.out.println(numbers5.stream()
                .map(n -> n * n)
                .collect(Collectors.toList()));

        //Задача 9: Получение среднего значения чисел
        List<Integer> numbers41 = Arrays.asList(1, 2, 3, 4, 5);

        //Задача 10: Получение списка квадратов чисел
        List<Integer> numbers51 = Arrays.asList(1, 2, 3, 4, 5);

        //Задача 11: Группировка строк по длине
        List<String> words4 = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        //Задача 12: Проверка, содержатся ли строки в списке
        List<String> words5 = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        List<String> searchWords = Arrays.asList("banana", "fig", "grape");

        //Задача 13: Поиск первой строки, удовлетворяющей условию
        List<String> words6 = Arrays.asList("apple", "banana", "cherry", "date");

        //Задача 14: Сокращение списка до указанного размера
        List<Integer> numbers6 = Homework.readIntegersFromFile();
        List<Integer> result14 = numbers6.stream()
                .takeWhile(n -> n < 6)
                .collect(Collectors.toList());
        System.out.println(result14);

        //Задача 15: Объединение двух списков в один
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);

        System.out.println(Stream.of(list1, list2).flatMap(Collection::stream).collect(Collectors.toList()));
        list1.stream().forEach(System.out::println);
        list1.stream().forEach(System.out::println);

    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
