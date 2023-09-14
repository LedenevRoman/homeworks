package com.telrun.rledenev.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class searchRepeatedNumber {
    public static void main(String[] args) {
        System.out.println(findRepeatedNumber(new int[]{1,2,3,4,1}, 4));
    }

    private static int findRepeatedNumber(int[] ints, int n) {
        Set<Integer> integers = new HashSet<>();
        for (int anInt : ints) {
            if (!integers.add(anInt)) {
                return anInt;
            }
        }
        return -1;
    }
}
