package _2023_06_13;

import java.util.*;

//Работа с итератором
public class CT4 {

    public static void main(String[] args) {
        List<String> strings = List.of("One", "Two", "Three");
        printList(strings);
    }

    /**
     * Задача 1: Перебрать и вывести все элементы Map<String, Integer> с использованием Iterator.
     */
    public static void printMap(Map<String, Integer> inputMap) {
        Set<Map.Entry<String, Integer>> entrySet = inputMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            System.out.println("Key: " + iterator.next().getKey() + ", Value: " + iterator.next().getValue());
        }
    }
    /**
     * Задача 2: Перебрать и вывести все элементы Set<String> с использованием Iterator.
     */
    public static void printSet(Set<String> inputSet) {
        Iterator<String> iterator = inputSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    /**
     * Задача 3: Перебрать и вывести все элементы List<String> с использованием ListIterator в обратном порядке.
     */
    public static void printList(List<String> inputList) {
        ListIterator<String> iterator = inputList.listIterator(inputList.size());

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}
