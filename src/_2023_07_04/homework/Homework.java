package _2023_07_04.homework;

import java.util.*;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {
        System.out.println(getWordsGroupedByLength(List.of("Aloha", "A", "AB", "ABAB", "ahola", "asdfg")));
        System.out.println(getUniqueSortedChars(List.of("Aloha", "A", "AB", "ABAB", "ahola", "asdfg")));
        System.out.println(getSecondMax(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));

    }

    //Дан список строк. Необходимо отфильтровать строки, длина которых больше 3 символов, преобразовать их в верхний регистр, удалить повторяющиеся и вывести результат в отсортированном порядке.
    public static List<String> getUniqueToUpperCase(List<String> strings) {
        return strings.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    //Дан список слов. Необходимо найти среднюю длину слов, начинающихся с буквы "A".
    public static double getAvgLengthOfWordsStartedWithA(List<String> strings) {
        return strings.stream()
                .filter(s -> s.startsWith("A"))
                .map(String::length)
                .mapToInt(i -> i)
                .average()
                .orElse(0.0);
    }

    //Дан список слов. Необходимо сгруппировать их по длине и вывести результат.
    public static Map<Integer, List<String>> getWordsGroupedByLength(List<String> words) {
        Map<Integer, List<String>> result = new HashMap<>();
        words.forEach(s -> result.merge(s.length(), List.of(s), (List<String> oldValue, List<String> newValue) -> {
            List<String> list = new ArrayList<>(oldValue);
            list.addAll(newValue);
            return list;
            //oldValue.addAll(newValue);
            //return oldValue;
        }));
        return result;
    }

    //Дан список чисел. Необходимо найти наименьшее число, больше 0.
    public static int findLesserAboveZero(List<Integer> integers) {
        return integers.stream()
                .filter(integer -> integer > 0)
                .mapToInt(i -> i)
                .min()
                .orElse(-1);
    }

    //Дан список чисел. Необходимо найти сумму квадратов всех положительных чисел.
    public static int getSumOfSquarePositiveNumbers(List<Integer> integers) {
        return integers.stream()
                .filter(integer -> integer > 0)
                .map(integer -> integer * integer)
                .mapToInt(i -> i)
                .sum();
    }

    //Даны два списка чисел. Необходимо объединить их в один список, отсортировать по убыванию и удалить повторяющиеся элементы.
    public static List<Integer> unionOfUniqueNumbers(List<Integer> list1, List<Integer> list2) {
        List<Integer> union = new ArrayList<>(list1);
        union.addAll(list2);
        return union.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    //Дан список строк. Необходимо оставить только уникальные символы из всех строк и вывести их в алфавитном порядке.
    public static List<Character> getUniqueSortedChars(List<String> list) {
        return list.stream()
                .flatMapToInt(String::chars)
                .mapToObj(ch -> (char) ch)
                .distinct()
                .sorted()
                .collect(Collectors.toList()); //[A, B, a, d, f, g, h, l, o, s] Почему то сортирует B < а
    }

    //Дан список чисел. Необходимо найти второе максимальное число.
    public static Integer getSecondMax(List<Integer> integers) {
        return integers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .findAny()
                .orElse(null);
    }

    //Дан список слов. Необходимо отфильтровать слова, состоящие только из букв, разделить их на гласные и согласные, и вывести результат.

    //Дан список строк. Необходимо удалить пустые строки, объединить оставшиеся строки в одну строку, разделенную запятой.
    //Дан список слов. Необходимо объединить все символы из всех слов в одну строку.
    //Дан список слов. Необходимо проверить, содержат ли они одинаковые символы (являются ли анаграммами) и вывести результат.
    //Даны два списка чисел. Необходимо найти разность множеств (элементы, присутствующие только в одном из списков) и вывести результат.
    //Дан список слов. Необходимо подсчитать количество слов для каждой длины и вывести результат.
    //Дан список строк. Необходимо отфильтровать строки, которые начинаются с префикса "pre" и заканчиваются суффиксом "post".
    //Дан список слов. Необходимо подсчитать количество символов в каждом слове и вывести результат.
    //Дан список чисел. Необходимо найти среднее значение всех уникальных чисел.
    //Дан список слов. Необходимо найти самое длинное слово с четной длиной.
    //Дан список строк. Необходимо удалить все пробелы в каждой строке, отсортировать их в лексикографическом порядке и вывести результат.
    //Дан список слов. Необходимо проверить, являются ли они палиндромами, и вывести результат.
    //Дан список чисел. Необходимо найти максимальное четное число.
    //Дан список строк. Необходимо объединить все строки в одну строку, добавив префикс ">>" и суффикс "<<" к каждой строке.
    //Дан список строк. Необходимо объединить все символы из всех строк, удалить дубликаты и отсортировать их в лексикографическом порядке.
    //Дан список объектов Person с полем "возраст". Необходимо отфильтровать объекты, возраст которых находится в диапазоне от 25 до 40 лет, отсортировать по имени и вывести результат.
    //Дан список чисел. Необходимо найти сумму всех четных чисел, которые являются положительными.
    //Дан список чисел. Необходимо найти второе минимальное число среди уникальных чисел.
    //Дан список слов. Необходимо разделить их на две группы: одна группа - слова с длиной менее или равной 4 символам, другая группа - слова с длиной более 4 символов. После этого подсчитать количество слов в каждой группе и вывести результат.
    //Дан список строк. Необходимо пропустить первые три символа в каждой строке и объединить оставшиеся символы в одну строку.
    //Дан список чисел. Необходимо найти три наименьших числа и вывести результат.
    //Дан список строк. Необходимо проверить, содержит ли хотя бы одна строка подстроку "an" и вывести результат.
}
