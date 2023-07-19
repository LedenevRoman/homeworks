package com.telrun.rledenev._2023_06_13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Для тех, кому все легко
public class HardCoreCocaineVersionOfCollectionTasks1 {

    public static void main(String[] args) {
        Boolean[][] booleans = {
                {true, false, true},
                {false, true, false},
                {true, true, false}
        };

        Integer[][] integers = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Map<Boolean[][], Character[][]> map1 = new HashMap<>();
        map1.put(booleans, null);

        Map<Integer[][], String[][]> map2 = new HashMap<>();
        map2.put(integers, null);

        System.out.println(transformMaps(map1, map2));
        System.out.println(transformMaps2(map1, map2));
    }
    /**
     * Создать новую Map<Character, String>,
     * где ключом будет символ из Character[][],
     * а значением будет соответствующая строка из String[][].
     * Необходимо выполнить следующие шаги:
     * <p>
     * Перебрать элементы первой мапы (Map<Boolean[][], Character[][]>).
     * Для каждого элемента преобразовать Boolean[][] в Character[][], заменив значения true на символ 'T' и false на символ 'F'.
     * Перебрать элементы второй мапы (Map<Integer[][], String[][]>).
     * Для каждого элемента преобразовать Integer[][] в String[][], преобразовав каждое число в строку.
     * Объединить соответствующие элементы из шагов 2 и 4 в новой мапе (Map<Character, String>).
     * <p>
     * public static Map<Character, String> transformMaps(Map<Boolean[][], Character[][]> map1, Map<Integer[][], String[][]> map2)
     */
    public static Map<Character, String> transformMaps(Map<Boolean[][], Character[][]> map1, Map<Integer[][], String[][]> map2) {
        List<Character[][]> charactersList = map1.entrySet()
                .stream()
                .map(entry -> {
                    Boolean[][] booleans = entry.getKey();
                    Character[][] characters = new Character[booleans.length][];
                    for (int i = 0; i < booleans.length; i++) {
                        Character[] charactersSubArray = new Character[booleans[i].length];
                        for (int j = 0; j < booleans[i].length; j++) {
                            charactersSubArray[j] = (booleans[i][j] ? 'T' : 'F');
                        }
                        characters[i] = charactersSubArray;
                    }
                    entry.setValue(characters);
                    return characters;
                })
                .collect(Collectors.toList());

        List<String[][]> stringsList = map2.entrySet()
                .stream()
                .map(entry -> {
                    Integer[][] integers = entry.getKey();
                    String[][] strings = new String[integers.length][];
                    for (int i = 0; i < integers.length; i++) {
                        String[] stringsSubArray = new String[integers[i].length];
                        for (int j = 0; j < integers[i].length; j++) {
                            stringsSubArray[j] = integers[i][j].toString();
                        }
                        strings[i] = stringsSubArray;
                    }
                    entry.setValue(strings);
                    return strings;
                })
                .collect(Collectors.toList());

        Map<Character, String> result = new HashMap<>();

        for (int i = 0; i < charactersList.size() && i < stringsList.size(); i++) {
            Character[][] characters = charactersList.get(i);
            String[][] strings = stringsList.get(i);
            for (int j = 0; j < characters.length; j++) {
                for (int k = 0; k < characters[j].length; k++) {
                    result.merge(characters[j][k], strings[j][k], (oldValue, newValue) -> oldValue + " " + newValue);
                }
            }
        }
        return result;
    }

    /**
     * Создать новую Map<String, Boolean>, где ключом будет строка из String[][], а значением будет
     * соответствующее значение из Boolean[][]. Необходимо выполнить следующие шаги:
     *
     * Перебрать элементы первой мапы (Map<Boolean[][], Character[][]>).
     * Для каждого элемента преобразовать Boolean[][] в Character[][],
     * заменив значения true на символ 'T' и false на символ 'F'.
     * Перебрать элементы второй мапы (Map<Integer[][], String[][]>).
     * Для каждого элемента преобразовать Integer[][] в String[][], преобразовав каждое число в строку.
     * Объединить соответствующие элементы из шагов 2 и 4 в новой мапе (Map<String, Boolean>).
     *
     * public static Map<String, Boolean> transformMaps(Map<Boolean[][], Character[][]> map1, Map<Integer[][], String[][]> map2)
     */

    public static Map<String, Boolean> transformMaps2(Map<Boolean[][], Character[][]> map1, Map<Integer[][], String[][]> map2) {
        List<Boolean[][]> booleansList = map1.entrySet()
                .stream()
                .map(entry -> {
                    Boolean[][] booleans = entry.getKey();
                    Character[][] characters = new Character[booleans.length][];
                    for (int i = 0; i < booleans.length; i++) {
                        Character[] charactersSubArray = new Character[booleans[i].length];
                        for (int j = 0; j < booleans[i].length; j++) {
                            charactersSubArray[j] = (booleans[i][j] ? 'T' : 'F');
                        }
                        characters[i] = charactersSubArray;
                    }
                    entry.setValue(characters);
                    return booleans;
                })
                .collect(Collectors.toList());

        List<String[][]> stringsList = map2.entrySet()
                .stream()
                .map(entry -> {
                    Integer[][] integers = entry.getKey();
                    String[][] strings = new String[integers.length][];
                    for (int i = 0; i < integers.length; i++) {
                        String[] stringsSubArray = new String[integers[i].length];
                        for (int j = 0; j < integers[i].length; j++) {
                            stringsSubArray[j] = integers[i][j].toString();
                        }
                        strings[i] = stringsSubArray;
                    }
                    entry.setValue(strings);
                    return strings;
                })
                .collect(Collectors.toList());

        Map<String, Boolean> result = new HashMap<>();

        for (int i = 0; i < booleansList.size() && i < stringsList.size(); i++) {
            Boolean[][] booleans = booleansList.get(i);
            String[][] strings = stringsList.get(i);
            for (int j = 0; j < booleans.length; j++) {
                for (int k = 0; k < booleans[j].length; k++) {
                    result.put(strings[j][k], booleans[j][k]);
                }
            }
        }
        return result;
    }
}
