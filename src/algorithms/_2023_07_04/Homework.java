package algorithms._2023_07_04;

import java.util.Arrays;

public class Homework {

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4};
        System.out.println(Arrays.toString(mergeSort(array)));
        System.out.println(Arrays.toString(addOne(array)));
    }
     /**
      Написать самостоятельно сортировку слиянием.
      Стереть все то, что написали во время классной работы и заново написать merge sort, опираясь на текстовое описание и псевдокод.
      */

     public static int[] mergeSort(int[] inputArr) {
        if (inputArr.length == 1) {
            return inputArr;
        }
        if (inputArr.length == 2) {
            if (inputArr[0] > inputArr[1]) {
                int temp = inputArr[0];
                inputArr[0] = inputArr[1];
                inputArr[1] = temp;
            }
            return inputArr;
        }

        int mid = inputArr.length / 2;
        int[] bottomArr = new int[mid];
        int[] topArr = new int[inputArr.length - mid];

        for (int i = 0; i < inputArr.length; i++) {
            if (i < mid) {
                bottomArr[i] = inputArr[i];
            } else {
                topArr[i - mid] = inputArr[i];
            }
        }

        return mergeArrays(mergeSort(bottomArr), mergeSort(topArr));
    }

    private static int[] mergeArrays(int[] array1, int[] array2) {
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
        return resultArray;
    }

    /**
     * Дано число, которое задано своими разрядами, расположенными в массиве. Прибавить к этому числу 1.
     */
    public static int[] addOne(int[] numberArr) {
        int number = 0;
        int increment = 1;
        for (int i = numberArr.length - 1; i >= 0; i--) {
            number += numberArr[i] * increment;
            increment *= 10;
        }
        number++;
        return String.valueOf(number).chars()
                .mapToObj(c -> (char) c)
                .mapToInt(Character::getNumericValue)
                .toArray();
    }
}
