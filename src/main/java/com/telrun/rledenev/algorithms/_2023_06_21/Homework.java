package com.telrun.rledenev.algorithms._2023_06_21;

public class Homework {
    public static void main(String[] args) {
        int[] arr1 = {100, 112, 256, 349, 770};
        int[] arr2 = {72, 86, 113, 119, 265, 445, 892};
        System.out.println(findElementOnIndexOfBothSortedArrays(arr1, arr2, 11));
        System.out.println(recursiveBinarySearch(arr2, 119, 0, arr1.length - 1));
    }

    /** Имея два отсортированных массива размера m и n соответственно,
     * вам нужно найти элемент, который будет находиться на k-й позиции в конечном отсортированном массиве.
     */
    public static int findElementOnIndexOfBothSortedArrays(int[] array1, int[] array2, int k) {
        int[] resultArray = new int[array1.length + array2.length];
        int pointer1 = 0;
        int pointer2 = 0;
        int pointerResult = 0;
        while (pointer1 < array1.length || pointer2 < array2.length) {
            if (pointer1 == array1.length) {
                resultArray[pointerResult] = array2[pointer2];
                pointer2++;
                pointerResult++;
                continue;
            }
            if (pointer2 == array2.length) {
                resultArray[pointerResult] = array1[pointer1];
                pointer1++;
                pointerResult++;
                continue;
            }
            if (array1[pointer1] <= array2[pointer2]) {
                resultArray[pointerResult] = array1[pointer1];
                pointer1++;

            } else {
                resultArray[pointerResult] = array2[pointer2];
                pointer2++;
            }
            pointerResult++;
        }
        return resultArray[k - 1];
    }

    /** Реализовать рекурсивный алгоритм бинарного поиска. Используйте стратегию "разделяй и властвуй".
     */
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
}
