package com.telrun.rledenev._2023_06_23;

import java.util.*;

public class ClassTask {
    public static void main(String[] args) {
        int[][] arr2 = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[] ints = new int[]{4, 3, 2, 1, 0};
        System.out.println(Arrays.toString(getSumOfEachRow(arr2)));
        System.out.println(getIndexBinary(ints, 0, ints.length - 1));
    }

    // 2. Дан двумерный массив из N строк. Нужно найти для каждой строки сумму всех значений колонок
    // и сохранить в массиве размера N.
    private static int[] getSumOfEachRow(int[][] arr) {
        int[] result = new int[arr.length];


        for (int i = 0; i < arr.length; i++) {
            for (int num : arr[i]) {
                result[i] += num;
            }
        }
        return result;
    }

/*        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                result[i] += arr[i][j];
            }
        }*/

    // 3. Очередь. Добавить N элементов из целых чисел. Удалить отрицальные элементы из начала очереди и вывести
    // их на экран.
    private static void get() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(-5);
        queue.add(-2);
        queue.add(0);
        queue.add(4);
        queue.add(6);

        while ((!queue.isEmpty()) && queue.peek() < 0) {
            System.out.println(queue.remove());
        }
    }

    private static int recursiveBinarySearch(int[] array, int key, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (array[mid] < key) {
            return recursiveBinarySearch(array, key, mid + 1, high);
        } else if (array[mid] > key) {
            return recursiveBinarySearch(array, key, low, mid - 1);
        } else {
            return mid;
        }
    }

    private static int getIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if ((i - 1 < 0 || arr[i - 1] < arr[i]) && (i + 1 == arr.length || arr[i + 1] < arr[i])) {
                return i;
            }
        }
        return  -1;
    }

    private static int getIndexBinary(int[] arr, int low, int high) {
        int midIndex = (low + high) / 2;

        if (low == high) return midIndex;
        if (high - low == 1) return arr[low] < arr[high] ? high : low;

        if (arr[midIndex - 1] > arr[midIndex]) {
            return getIndexBinary(arr, low, midIndex - 1);
        } else if (arr[midIndex + 1] > arr[midIndex]) {
            return getIndexBinary(arr, midIndex + 1, high);
        } else {
            return midIndex;
        }
    }

    private static int getElem(int[] arr, int i) {
        if (i < 0 || i >= arr.length) {
            return Integer.MIN_VALUE;
        }
        return arr[i];
    }
}
