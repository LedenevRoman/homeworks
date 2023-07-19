package com.telrun.rledenev._2023_07_13.homework;

public class Main {
    public static void main(String[] args) {
        Homework.writeArrayToFile();
        System.out.println(Homework.readIntegersFromFile());
        System.out.println(Homework.readLinesFromFile());
        System.out.println(Homework.readWordsFromFile());
    }
}
