package com.telrun.rledenev._2023_06_15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DARRAY {
    public static void main(String[] args) {
        printSumOfEachRow(generateDoubleArrayOfInts());
        printHighestElementOfEachColumn(generateDoubleArrayOfInts());
        printSortedEachRow(generateDoubleArrayOfInts());
        printCountOfElementInEachColumn(generateDoubleArrayOfInts(), new Random().nextInt(100));
    }
        /**
         * 1. Найти сумму всех элементов в каждой
         * строке двумерного массива и вывести на экран.
         */

        public static void printSumOfEachRow(int[][] inputArray) {
            Map<Integer, Integer> result = new HashMap<>();

            for (int i = 0; i < inputArray.length; i++) {
                int sum = 0;
                for (int j = 0; j < inputArray[i].length; j++) {
                    sum += inputArray[i][j];
                }
                result.put(i, sum);
            }
            System.out.println(result);
        }
        /**
         * 2. Найти наибольший элемент в
         * каждом столбце двумерного массива и вывести на экран.
         */
        public static void printHighestElementOfEachColumn(int[][] inputArray) {
            Map<Integer, Integer> result = new HashMap<>();

            for (int i = 0; i < inputArray[0].length; i++) {
                int higest = Integer.MIN_VALUE;
                for (int[] ints : inputArray) {
                    if (ints[i] > higest) {
                        higest = ints[i];
                    }
                }
                result.put(i, higest);
            }
            System.out.println(result);
        }
        /**
         * 3. Отсортировать каждую строку двумерного массива
         * в порядке возрастания и вывести отсортированный массив на экран.
         */
        public static void printSortedEachRow(int[][] inputArray) {
            for (int[] ints : inputArray) {
                Arrays.sort(ints);
                System.out.println(Arrays.toString(ints));
            }
        }
        /**
         * 4. Посчитать количество вхождений определенного
         * числа в каждом столбце двумерного массива и вывести на экран.
         */
        public static void printCountOfElementInEachColumn(int[][] inputArray, int number) {
            Map<Integer, Integer> result = new HashMap<>();

            for (int i = 0; i < inputArray[0].length; i++) {
                result.put(i, 0);
                for (int[] ints : inputArray) {
                    if (ints[i] == number) {
                        result.compute(i, (k, v) -> v + 1);
                    }
                }
            }
            System.out.println(result);
        }
        /**
         * СНАЧАЛА СОЗДАТЬ МЕТОД КОТОРЫЙ ВОЗВРАЩАЕТ СГЕНЕРИРОВАННЫЙ
         * ДВУМЕРНЫЙ МАССИВ РАНДОМНОЙ ДЛИНЫ И ВЫСОТЫ И С РАНДОМНЫМИ ЧИСЛАМИ
         * ДАЛЕЕ ПЕРЕДАВАТЬ РЕЗУЛЬТАТ РАБОТЫ ЭТОГО МЕТОДА В КАЧЕСТВЕ ПАРАМЕТРА
         */


    public static int[][] generateDoubleArrayOfInts() {
        Random random = new Random();
        int length = random.nextInt(100) + 1;
        int high = random.nextInt(100) + 1;

        int[][] dArray = new int[high][length];

        for (int i = 0; i < high; i++) {
            for (int j = 0; j < length; j++) {
                dArray[i][j] = random.nextInt(100);
            }
        }
        return dArray;
    }
}
