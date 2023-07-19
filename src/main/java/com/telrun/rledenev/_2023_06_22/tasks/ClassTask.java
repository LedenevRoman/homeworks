package com.telrun.rledenev._2023_06_22.tasks;

import java.util.*;

public class ClassTask {

    /**
     * - У вас есть Map<String, Boolean>, представляющая студентов и их оценки
     * (true - сдал экзамен, false - не сдал).
     * Напишите функцию, которая находит и возвращает имена студентов, не сдавших экзамен.
     */

    public static Set<String> findStudentsWithFalseValue(Map<String, Boolean> stringBooleanMap) {
        Set<String> result = new HashSet<>();

        for (Map.Entry<String, Boolean> entry : stringBooleanMap.entrySet()) {
            if (entry.getValue().equals(false)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    /**
     * - У вас есть Map<String, Boolean>, представляющая список продуктов в магазине и
     * информацию о их наличии (true - продукт в наличии, false - продукта нет).
     * Напишите функцию, которая подсчитывает количество продуктов, которых нет в наличии.
     */
    public static int amountOfProducts(Map<String, Boolean> productsMap) {
        int amount = 0;
        for (Map.Entry<String, Boolean> item : productsMap.entrySet()) {
            if (item.getValue().equals(false)) {
                amount++;
            }
        }
        return amount;
    }

    /**
     * - У вас есть список List<String>, содержащий имена людей.
     * Напишите программу, которая выводит все имена, начинающиеся на определенную букву.
     * List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank");
     * char targetLetter = 'C';
     */

    public static List<String> findNames(List<String> list, char x) {
        List<String> result = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith(String.valueOf(x))) {
                result.add(s);
            }
        }
        return result;
    }

    /**
     * - У вас есть список List<String>, содержащий слова.
     * Напишите программу, которая находит все пары слов, в которых первое слово является обратным написанию второго слова.
     * List<String> words = Arrays.asList("lemon", "cat", "tac", "dog", "god", "man", "nam");
     */

    public static Map<String, String> findPaarWord(List<String> words) {
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder(words.get(i));
            String reverse = stringBuilder.reverse().toString();
            for (int j = i + 1; j < words.size(); j++) {
                if (reverse.equals(words.get(j))) {
                    result.put(words.get(i), words.get(j));
                }
            }
        }
        return result;
    }

    /**
     * -Напишите программу, которая принимает на вход двумерный
     * массив int[][] и возвращает сумму всех элементов в массиве.
     */
    public static int getSum(int[][] arr) {
        int sum = 0;
        for (int[] ints : arr) {
            for (int i : ints) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * -Напишите программу, которая принимает массив строк String[] и
     возвращает новый массив, содержащий только уникальные строки из исходного массива
     */
    public static String[] uniqueStrings(String[] strings) {
        Set<String> stringsSet = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (String string : strings) {
            if (stringsSet.add(string)) {
                result.add(string);
            } else {
                result.remove(string);
            }
        }
        return result.toArray(new String[0]);
    }

     /**
     -Напишите программу, которая принимает массив строк String[]
     и возвращает новый массив строк, в котором все строки перевернуты задом наперёд.
     */
     public static String[] reverseAll(String[] strings) {
         String[] result = new String[strings.length];
         for (int i = 0; i < strings.length; i++) {
             StringBuilder stringBuilder = new StringBuilder(strings[i]);
             result[i] = stringBuilder.reverse().toString();
         }
         return result;
     }

     /**
     -Напишите функцию, которая принимает на вход Set<String>
     и возвращает новый Set<String>, содержащий только те строки, которые начинаются с заглавной буквы.
     */
     private static Set<String> getStringsStartsWithUpperCase(Set<String> strings) {
         Set<String> result = new HashSet<>();
         for (String string : strings) {
             if (Character.isUpperCase(string.charAt(0))) {
                 result.add(string);
             }
         }
         return result;
     }

     /**
     -Напишите функцию, которая принимает на вход два Set<String> и
     возвращает новый Set<String>, содержащий только те строки, которые присутствуют в обоих наборах.
     */
     private static Set<String> intersectionOfSets(Set<String> strings1, Set<String> strings2) {
         Set<String> result = new HashSet<>(strings1);
         result.retainAll(strings2);
         return result;
     }

     /**
     - Напишите функцию, которая принимает на вход Set<String> и возвращает
     новый Set<String>, содержащий только уникальные строки, игнорируя регистр символов
     Set<String> stringSet = new HashSet<>();
     stringSet.add("Apple");
     stringSet.add("banana");
     stringSet.add("apple");
     stringSet.add("Banana");
     */
     private static Set<String> getUniqueIgnoreCase(Set<String> strings) {
         Set<String> result = new HashSet<>();
         Set<MyString> uniqueIgnoreCase = new HashSet<>();
         for (String string : strings) {
             uniqueIgnoreCase.add(new MyString(string));
         }
         for (MyString myString : uniqueIgnoreCase) {
             result.add(myString.getString());
         }
         return result;
     }
}

class MyString {
    private final String string;

    public MyString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyString myString = (MyString) o;
        return string.equalsIgnoreCase(myString.string);
    }

    @Override
    public int hashCode() {
        String stringForHash = string.toLowerCase();
        return Objects.hash(stringForHash);
    }
}
