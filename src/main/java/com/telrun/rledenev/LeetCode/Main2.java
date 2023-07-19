package com.telrun.rledenev.LeetCode;

import java.util.*;

class Main2 {

    public static int ArrayChallenge(String array) {
        Integer[] arr = Arrays.stream(array.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        int sum = 0;
        for (int j : arr) {
            sum = sum + j;
        }

        if (sum <= 0) {
            return sum * -1;
        }

        List<Integer> fibonacciSequence = new ArrayList<>();
        fibonacciSequence.add(0);
        fibonacciSequence.add(1);

        while (sum >= fibonacciSequence.get(fibonacciSequence.size() - 1)) {
            fibonacciSequence.add(fibonacciSequence.get(fibonacciSequence.size() - 1) + fibonacciSequence.get(fibonacciSequence.size() - 2));
        }

        return fibonacciSequence.get(fibonacciSequence.size() - 1) - sum;
    }

    public static int findMinFibonacciNumbers(int k) {
        List<Integer> fibonacciSequence = new ArrayList<>();
        fibonacciSequence.add(1);
        fibonacciSequence.add(2);

        while (k >= fibonacciSequence.get(fibonacciSequence.size() - 1) + fibonacciSequence.get(fibonacciSequence.size() - 2)) {
            fibonacciSequence.add(fibonacciSequence.get(fibonacciSequence.size() - 1) + fibonacciSequence.get(fibonacciSequence.size() - 2));
        }

        int count = 1;
        if (k == fibonacciSequence.get(fibonacciSequence.size() - 1)) {
            return count;
        }

        int currentSum = fibonacciSequence.get(fibonacciSequence.size() - 1);
        for (int i = fibonacciSequence.size() - 2; i >= 0; i--) {
            if (currentSum + fibonacciSequence.get(i) <= k) {
                currentSum = currentSum + fibonacciSequence.get(i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(findMinFibonacciNumbers(s.nextInt()));
    }
}
