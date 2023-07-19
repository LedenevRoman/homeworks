package com.telrun.rledenev.algorithms._2023_06_20;

public class Homework {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("1");

        stringBuilder.append("8".repeat(80));

        System.out.println(function(stringBuilder));

    }

    public static String function(StringBuilder string) {
            if (string.toString().startsWith("18")) {
                string.replace(0, 2, "2");
            } else if (string.toString().startsWith("288")) {
                string.replace(0, 3, "3");
            } else if (string.toString().startsWith("3888")) {
                string.replace(0, 4, "1");
            } else {
                return string.toString();
            }

            return function(string);
    }
}
