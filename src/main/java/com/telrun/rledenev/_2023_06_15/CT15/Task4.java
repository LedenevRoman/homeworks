package com.telrun.rledenev._2023_06_15.CT15;

import java.util.HashMap;
import java.util.Map;

/**     * 4. Создать и заполнить две мапы.
        * Затем перебрать обе мапы и создать новый мап
        * (Map<String, String>), где ключом будет имя человека,
        * а значением будет его возраст в виде строки.
        */
public class Task4 {
    public static void main(String[] args) {
        Map<String,Person> stringPersonMap = new HashMap<>();
        Map<String,Person> stringPersonMap1 = new HashMap<>();

        stringPersonMap.put("1", new Person("Ivan", 25));
        stringPersonMap.put("2", new Person("Petr", 35));

        stringPersonMap1.put("1", new Person("Sidr", 45));
        stringPersonMap1.put("2", new Person("Evgeniy", 55));

        Map<String, String> stringMap = new HashMap<>();

        for (Map.Entry<String, Person> entry : stringPersonMap.entrySet()) {
            stringMap.put(entry.getValue().getName(), Integer.toString(entry.getValue().getAge()));
        }

        for (Map.Entry<String, Person> entry : stringPersonMap1.entrySet()) {
            stringMap.put(entry.getValue().getName(), Integer.toString(entry.getValue().getAge()));
        }

        for (Map.Entry<String, String> entry : stringMap.entrySet()) {
            System.out.println("Имя: " + entry.getKey() + ", Возраст: " + entry.getValue());
        }
    }
}
