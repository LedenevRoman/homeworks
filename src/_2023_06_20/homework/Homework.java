package _2023_06_20.homework;

import java.util.*;
import java.util.stream.Collectors;

public class Homework {
    //Вывести все ключи из мапы на экран.

    public static void getKeys(Map<String, Integer> inputMap) {
        System.out.println(inputMap.keySet());
    }

    //Проверить, содержит ли мапа определенное значение.
    public static boolean containsValue(Map<String, Integer> inputMap, Integer value) {
        return inputMap.containsValue(value);
    }

    //Найти ключ, связанный с определенным значением.
    public static String getKeyOfValue(Map<String, Integer> inputMap, Integer value) {
        for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return "-1";
    }

    //Вывести на экран все ключи, у которых значение начинается с определенной буквы.
    public static Set<String> getKeyOfValueStartsWithLetter(Map<String, String> inputMap, String letter) {
        return inputMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue().startsWith(letter))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    //Проверить, содержит ли мапа определенный ключ.
    public static boolean containsKey(Map<String, Integer> inputMap, String key) {
        return inputMap.containsKey(key);
    }

    //Найти ключ с максимальным значением.
    public static String findKeyWithMaxValue(Map<String, Integer> inputMap) {
        String keyWithMaxValue = null;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                keyWithMaxValue = entry.getKey();
            }
        }
        return keyWithMaxValue;
    }

    //Подсчитать количество ключей, значение которых содержит определенное слово.
    public static int getCountOfKeysWithWordInValue(Map<String, String> inputMap, String string) {
        int count = 0;
        for (Map.Entry<String, String> entry : inputMap.entrySet()) {
            if (entry.getValue().contains(string)) {
                count++;
            }
        }
        return count;
    }

    //Найти все ключи, значение которых состоит только из цифр.
    public static Set<String> getKeysWithNumberValues(Map<String, String> inputMap) {
        return inputMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue().matches("\\d+"))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    //Подсчитать сумму числовых значений в мапе.
    public static int getSumOfNumericValues(Map<String, String> inputMap) {
        int sum = 0;
        for (Map.Entry<String, String> entry : inputMap.entrySet()) {
            if (entry.getValue().matches("\\d+")) {
                sum += Integer.parseInt(entry.getValue());
            }
        }
        return sum;
    }

    //Подсчитать количество ключей, у которых длина значения превышает определенную границу.
    public static int getCountOfKeysWitchValueLengthAboveBound(Map<String, String> inputMap, int bound) {
        int count = 0;
        for (Map.Entry<String, String> entry : inputMap.entrySet()) {
            if (entry.getValue().length() > bound) {
                count++;
            }
        }
        return count;
    }

    //Создать новую мапу, где значениями будут ключи, а ключами - значения исходной мапы.
    public static Map<Integer, String> getMapSwitchKeysAndValues(Map<String, Integer> inputMap) {
        Map<Integer, String> result = new HashMap<>();
        inputMap.forEach((key, value) -> result.put(value, key));
        return result;
    }

    //Очистить мапу и вывести сообщение о ее пустом состоянии.
    public static void clearMap(Map<String, Integer> inputMap) {
        inputMap.clear();
        System.out.println("Map is clear");
    }

    //Создать список List, заполнить его несколькими значениями и вывести на экран каждый элемент списка.
    public static List<Integer> generateListPrintValues() {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(3) + 2; i++) {
            int value = random.nextInt();
            integers.add(value);
            System.out.println(value);
        }
        return integers;
    }

    //Создать список List, заполнить его несколькими значениями. Затем перебрать список и вывести элементы в обратном порядке.
    public static List<Integer> generateListPrintValuesReverse() {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(3) + 2; i++) {
            integers.add(random.nextInt());
        }
        ListIterator<Integer> listIterator = integers.listIterator(integers.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
        return integers;
    }

    //Вычислить сумму всех элементов в массиве int[] и вывести результат.
    public static void printSumOfArray(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        System.out.println(sum);
    }

    //Найти наименьший и наибольший элементы в массиве int[] и вывести их.
    public static void printMinAndMaxElement(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }

    //Подсчитать количество четных элементов в массиве int[] и вывести результат.
    public static void printCountOfEvenNumbers(int[] array) {
        int count = 0;
        for (int i : array) {
            if (i % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    //Отсортировать массив int[] в порядке убывания и вывести отсортированный массив.
    public static void printSortReversOrder(int[] array) {
        Integer[] integers = Arrays.stream(array)
                .boxed()
                .toArray(Integer[]::new);
        Arrays.sort(integers, Comparator.reverseOrder());
        System.out.println(Arrays.toString(integers));
    }

    //Подсчитать сумму квадратов всех элементов в массиве int[] и вывести результат.
    public static void printSumOfSquare(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i * i;
        }
        System.out.println(sum);
    }

    //Посчитать сумму всех элементов во всем массиве.[][]
    public static void printSum(int[][] inputArray) {
        int sum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                sum += inputArray[i][j];
            }
        }
        System.out.println(sum);
    }

    //Найти максимальное значение в каждой строке и вывести его.[][]
    public static void printMaxElementInRow(int[][] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < inputArray[i].length; j++) {
                if (inputArray[i][j] > max) {
                    max = inputArray[i][j];
                }
                System.out.println("row " + i + ": " + max);
            }
        }
    }

    //Найти среднее значение элементов в каждом столбце и вывести его.[][]
    public static void printAverageValueOfEachColumn(int[][] inputArray) {
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < inputArray[0].length; i++) {
            int sum = 0;
            for (int[] ints : inputArray) {
                sum += ints[i];
            }
            System.out.println("Column " + i + ": " + sum / inputArray.length);
        }
    }
    //Посчитать количество элементов, кратных заданному числу, во всем массиве.[][]
    public static void printCountOfElementsMultipleOfNumber(int[][] inputArray, int number) {
        int count = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                if (inputArray[i][j] % number == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    //Найти сумму элементов только в нечетных строках массива.[][]
    public static void printSumOfOddRow(int[][] inputArray) {
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < inputArray.length; i++) {
            if (i % 2 == 0) {
                int sum = 0;
                for (int j = 0; j < inputArray[i].length; j++) {
                    sum += inputArray[i][j];
                }
                result.put(i, sum);
            }
        }
        System.out.println(result);
    }
}
