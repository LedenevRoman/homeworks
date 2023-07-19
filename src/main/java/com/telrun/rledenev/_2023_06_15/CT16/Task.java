package com.telrun.rledenev._2023_06_15.CT16;

public class Task {
    public static void printSortedSquares2(int[] arr) {
        int minAbs = Integer.MAX_VALUE;
        int minAbsIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            int abs = Math.abs(arr[i]);
            if (abs < minAbs) {
                minAbs = abs;
                minAbsIndex = i;
            }
        }
        int right = minAbsIndex;
        int left = minAbsIndex - 1;
        while (right < arr.length || left >= 0) {
            if (left < 0) {
                System.out.println(arr[right] * arr[right]);
                right++;
                continue;
            }
            if (right == arr.length) {
                System.out.println(arr[left] * arr[left]);
                left--;
                continue;
            }
            if (arr[left] * arr[left] <= arr[right] * arr[right]) {
                System.out.println(arr[left] * arr[left]);
                left--;
            } else {
                System.out.println(arr[right] * arr[right]);
                right++;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new Integer(10).equals(10));
        printSortedSquares2(new int[]{-10, -5, 1, 3, 7, 11});
    }

}
