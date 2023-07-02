package LeetCode;

import java.util.Random;

public class Main3 {
    public static void main(String[] args) {
        String[] strings = {"AAA", "BBB", "CCC", "DDD", "EEE", null};
        for (int i = strings.length - 1; i >= 0; i--) {
            if ("AAA".equals(strings[i])) {
                System.out.println(strings[i]);
            }
        }

        System.out.println(10 & 11);

        Integer integer = 11;

    }
}
