package com.telrun.rledenev.LeetCode;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6,7, 8, 9, 0,1,2};
        System.out.println(findIndexOfMinElement(arr));
    }

    private static int findIndexOfMinElement(int[] arr) {
        return findIndexMinElementBinary(arr, 0, arr.length - 1);
    }

    private static int findIndexMinElementBinary(int[] arr, int bot, int top) {
        if (bot >= top) {
            return top;
        }
        int mid = (top + bot) / 2;
        if (arr[mid] < arr[mid - 1]) {
            return mid;
        } else if (arr[mid] < arr[top]) {
            return findIndexMinElementBinary(arr, bot, mid - 1);
        } else {
            return findIndexMinElementBinary(arr, mid + 1, top);
        }
    }
}
