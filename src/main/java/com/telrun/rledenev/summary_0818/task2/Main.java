package com.telrun.rledenev.summary_0818.task2;

public class Main {
    public static void main(String[] args) {
        System.out.println(FinderCreator.createFinder("src/main/java/com/telrun/rledenev/summary_0818/task2/example.csv")
                .find("QUANTITY", "250#3"));
    }
}
