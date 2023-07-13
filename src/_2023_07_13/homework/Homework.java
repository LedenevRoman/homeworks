package _2023_07_13.homework;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public final class Homework {
    private static final String FILE_NAME_NUMBERS = "integers.txt";
    private static final String FILE_NAME_STRINGS = "wpe.txt";

    private Homework() {
    }

    public static void writeArrayToFile() {
        int[] array = generateIntArray();

        try (FileWriter fileWriter = new FileWriter(FILE_NAME_NUMBERS)) {
            for (int i = 0; i < array.length; i++) {
                fileWriter.write(String.valueOf(array[i]));
                if (i != array.length - 1) {
                    fileWriter.write(",");
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static List<Integer> readIntegersFromFile() {
        StringBuilder stringBuilder = new StringBuilder();

        try (FileReader fileReader = new FileReader(FILE_NAME_NUMBERS)) {
            int character;
            while ((character = fileReader.read()) != -1) {
                stringBuilder.append((char) character);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        String[] numbers = stringBuilder.toString().split(",");
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<String> readLinesFromFile() {
        List<String> string = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME_STRINGS))) {
            string = reader.lines().collect(Collectors.toList());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return string;
    }

    public static List<String> readWordsFromFile() {
        String string = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME_STRINGS))) {
            string = reader.lines().collect(Collectors.joining());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        assert string != null;
        return Arrays.stream(string.split("[,.\\s!?;\"]"))
                .filter(s -> !s.isEmpty() && !s.equals("-"))
                .map(s -> {
                    if (s.matches("\\p{L}+-\\p{L}+")) {
                        s = s.replace("-", "");
                    }
                    return s;
                })
                .collect(Collectors.toList());
    }

    private static int[] generateIntArray() {
        Random random = new Random();
        int arrayLength = random.nextInt(26) + 25;
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}
