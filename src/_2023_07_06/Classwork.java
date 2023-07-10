package _2023_07_06;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Classwork {
    public static void main(String[] args) {

        Random random = new Random();

        LocalDate currentDate = LocalDate.now();
        int randomDayOffset = random.nextInt(1825);
        LocalDate cardExpireDate = currentDate.plusDays(randomDayOffset);
        System.out.println(cardExpireDate);

        //Задача 1: Подсчет количества уникальных четных и нечетных чисел
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        System.out.println(numbers.stream()
                .distinct()
                .collect(Collectors.groupingBy(n -> n % 2, Collectors.counting())));

        //Задача 2: Группировка строк по первым буквам и вывод первых двух из каждой группы
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "apfel", "ananas");
        Map<Character, List<String>> collect = words.stream()
                .collect(Collectors.groupingBy(n -> n.toLowerCase().charAt(0)));
        collect.forEach((key, value) -> {
            System.out.println("Key: " + key + ", value: " + value.stream().limit(2).collect(Collectors.toList()));
        });

        //Задача 5: Разделение чисел на простые и составные
        List<Integer> numbers3 = Arrays.asList(2, 3, 4, 5, 67, 8, 9, 10, 11, 12, 13, 14, 15);
        Map<Boolean, List<Integer>> result = numbers3.stream()
                .collect(Collectors.partitioningBy(Classwork::isPrime));
        System.out.println(result);


        //Задача 6: Получение уникальных символов из списка строк
        List<String> words2 = Arrays.asList("apple", "banana", "cherry", "date");
        List<Character> result2 = words2.stream()
                .flatMapToInt(String::chars)
                .mapToObj(ch -> (char) ch)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result2);


        //Задача 7: Разделение строк на отдельные слова и удаление повторений
        List<String> sentences = Arrays.asList("Hello world", "Java is awesome", "Stream API is powerful");
        List<String> result3 = sentences.stream()
                .flatMap(string -> Arrays.stream(string.toLowerCase().split(" ")))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result3);


        //Задача 8: Фильтрация и преобразование строк toUpperCase
        List<String> words3 = Arrays.asList("apple", "banana", "cherry", "date");
        System.out.println(words3.stream()
                .filter(str -> str.length() >= 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList()));

        //Задача 9: Получение среднего значения чисел
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers4.stream()
                .mapToInt(Integer::valueOf)
                .average()
                .orElse(0.0));
        //Задача 10: Получение списка квадратов чисел
        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5);
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
        List<Integer> numbers6 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result14 = numbers6.stream()
                .takeWhile(n -> n < 6)
                .collect(Collectors.toList());
        System.out.println(result14);

        //Задача 15: Объединение двух списков в один
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);

        System.out.println(Stream.of(list1, list2).flatMap(Collection::stream).collect(Collectors.toList()));

        List<String> names = new ArrayList<>();
        names.add("Vlad");
        names.add("Mik");
        names.add("Mick");
        names.add("V");

        names.stream()
                .filter(name -> name.startsWith("V"))
                .onClose(() -> System.out.println("Stream closed"))
                .forEach(System.out::println);

        System.out.println("/////////////////////////////////////////");

        names.stream()
                .filter(name -> name.startsWith("M"))
                .onClose(() -> closeStream(names))
                .close();
    }

    private static void closeStream(List<String> names) {
        System.out.println("Stream closed");
        names.clear();
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
