package com.telrun.rledenev._2023_06_29.Classwork;

import java.util.*;
import java.util.stream.Collectors;

public class ClassTask {

    public static void main(String[] args) {

        List<Person> personList = List.of(new Person("Olga", 15),
                new Person("Anton", 35),
                new Person("Oleg", 50),
                new Person("Andrey", 26));

        System.out.println(getPersonsAdultSorted(personList));

        System.out.println(getSumOfEvenNumbers(List.of(1,2,3,4,5,6,7,8,9)));
    }

    /**
     * Дан список чисел. Необходимо отфильтровать только положительные числа и вывести их в отсортированном порядке.
     */

    /**
     * Дан список строк. Необходимо преобразовать каждую строку в верхний регистр, удалить повторяющиеся строки и вывести результат.
     */

    /**
     * Дан список объектов Person. Необходимо отфильтровать только совершеннолетних людей, отсортировать по имени и вывести результат.
     * Person {
     *     String name
     *     int age
     * }
     */

    private static List<Person> getPersonsAdultSorted(List<Person> persons) {
        return persons.stream()
                .filter(person -> person.getAge() >= 18)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Дан список чисел. Необходимо найти сумму всех четных чисел.
     */
    private static int getSumOfEvenNumbers(List<Integer> integers) {
        return integers.stream()
                .filter(integer -> integer % 2 == 0)
                .reduce(0, (int1, int2) -> int1 + int2);
    }

    /**
     * Дан список чисел. Необходимо найти среднее значение всех чисел. //average()
     */
    private static void getAvg() {
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(list3.stream()
                .mapToDouble(i -> i)
                .average().getAsDouble());
    }

    /**
     * Дан список слов. Необходимо найти самое длинное слово.
     */
    private static void getMaxLengthWord() {
        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        //Comparator<String> comparator = (o1, o2) -> o1.length() - o2.length(); //2 способ
        //Comparator<String> comparator = Comparator.comparingInt(String::length); //3 способ
        List<String> stringList1 = Arrays.asList("aaa", "aaaa", "aaaaa");
        System.out.println(stringList1.stream()
                .max(comparator).get());
    }

    /**
     * Дан список чисел. Необходимо пропустить первые два элемента и вывести остальные
     */

    /**
     * Дан список слов. Необходимо проверить, содержит ли он хотя бы одно слово, начинающееся с буквы "A".
     */
    /**
     * Дан список строк. Необходимо объединить их в одну строку, разделенную запятой. //Collectors.joining()
     */
    /**
     * Дан список объектов Person. Необходимо сгруппировать их по возрасту и вывести результат.
     */
    private static Map<String, List<Person>> getPersonsGroupedByAge(List<Person> personList) {
        Map<String, List<Person>> result = new HashMap<>();
        List<Person> notAdultPersons = personList.stream()
                .filter(person -> person.getAge() < 18)
                .collect(Collectors.toList());
        List<Person> adultPersons = personList.stream()
                .filter(person -> person.getAge() >= 18)
                .collect(Collectors.toList());
        result.put("Not Adults", notAdultPersons);
        result.put("Adults", adultPersons);

        return result;
    }

    /**
     * Дан список чисел. Необходимо проверить, являются ли все числа положительными.
     */
    /**
     * Дан список чисел. Необходимо найти первое четное число.
     */
    /**
     * Дан список чисел. Необходимо умножить все числа на заданное значение.
     */
    /**
     * Дан список строк. Необходимо найти сумму длин всех строк.
     */
    /**
     * Дан список чисел. Необходимо преобразовать его в массив.
     */
}
