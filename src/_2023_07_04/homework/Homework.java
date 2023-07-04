package _2023_07_04.homework;

import java.util.*;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {
        System.out.println(getWordsGroupedByLength(List.of("Aloha", "A", "AB", "ABAB", "ahola", "asdfg")));
        System.out.println(getUniqueSortedChars(List.of("Aloha", "A", "AB", "ABAB", "ahola", "asdfg")));
        System.out.println(getSecondMax(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        System.out.println(getFilteredGroupedWords(List.of("as123fadd","Aloha", "A", "AB", "ABAB", "ahola", "asdfg")));
        System.out.println(getLongestWordWithEvenLength(List.of("as123fadd","Aloha", "A", "AB", "ABAB",
                "ahola", "asdfg", "121212121212")));
        System.out.println(isPalindromes(List.of("Aloha", "Ahola", "Laoha", "Ahalo", "ahoal", "olaha")));
        System.out.println(getMaxEvenNumber(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        System.out.println(transformToStringWithBrackets(List.of("Aloha", "Ahola", "Laoha", "Ahalo", "ahoal", "olaha")));
        System.out.println(getUniqueCharacters(List.of("Aloha", "Ahola", "Laoha", "Ahalo", "ahoal", "olaha")));
        System.out.println(getPersonsFrom25To40Sorted(List.of(new Person("Anton", 25),
                new Person("Boris", 33), new Person("Aleksey", 35))));
        System.out.println(getSecondMinimalOfUniqueNumbers(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 1)));
        System.out.println(getCountOfWordsGroupedByLength(List.of("as123fadd","Aloha", "A", "AB", "ABAB", "ahola",
                "asdfg", "121212121212")));
    }

    //Дан список строк. Необходимо отфильтровать строки, длина которых больше 3 символов, преобразовать их в верхний регистр, удалить повторяющиеся и вывести результат в отсортированном порядке.
    public static List<String> getUniqueToUpperCase(List<String> strings) {
        return strings.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    //Дан список слов. Необходимо найти среднюю длину слов, начинающихся с буквы "A".
    public static double getAvgLengthOfWordsStartedWithA(List<String> strings) {
        return strings.stream()
                .filter(s -> s.startsWith("A"))
                .map(String::length)
                .mapToDouble(i -> i)
                .average()
                .orElse(0.0);
    }

    //Дан список слов. Необходимо сгруппировать их по длине и вывести результат.
    public static Map<Integer, List<String>> getWordsGroupedByLength(List<String> words) {
        return words.stream()
                .collect(Collectors.toMap(String::length, List::of, (oldValue, newValue) -> {
                    List<String> list = new ArrayList<>(oldValue);
                    list.addAll(newValue);
                    return list;
/*                    oldValue.addAll(newValue);
                    return oldValue;  UnsupportedOperationException*/
                }));
    }

    //Дан список чисел. Необходимо найти наименьшее число, больше 0.
    public static int findLesserAboveZero(List<Integer> integers) {
        return integers.stream()
                .filter(integer -> integer > 0)
                .mapToInt(i -> i)
                .min()
                .orElse(-1);
    }

    //Дан список чисел. Необходимо найти сумму квадратов всех положительных чисел.
    public static int getSumOfSquarePositiveNumbers(List<Integer> integers) {
        return integers.stream()
                .filter(integer -> integer > 0)
                .map(integer -> integer * integer)
                .mapToInt(i -> i)
                .sum();
    }

    //Даны два списка чисел. Необходимо объединить их в один список, отсортировать по убыванию и удалить повторяющиеся элементы.
    public static List<Integer> unionOfUniqueNumbers(List<Integer> list1, List<Integer> list2) {
        List<Integer> union = new ArrayList<>(list1);
        union.addAll(list2);
        return union.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    //Дан список строк. Необходимо оставить только уникальные символы из всех строк и вывести их в алфавитном порядке.
    public static List<Character> getUniqueSortedChars(List<String> list) {
        return list.stream()
                .flatMapToInt(String::chars)
                .mapToObj(ch -> (char) ch)
                .distinct()
                .sorted(Comparator.comparingInt(Character::toLowerCase))
                .collect(Collectors.toList());
    }

    //Дан список чисел. Необходимо найти второе максимальное число.
    public static Integer getSecondMax(List<Integer> integers) {
        return integers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
    }

    //Дан список слов. Необходимо отфильтровать слова, состоящие только из букв, разделить их на гласные и согласные, и вывести результат.
    public static List<Map<String, List<String>>> getFilteredGroupedWords(List<String> words) {
        String consonants = "bcdfghjklmnpqrstvwxyz";
        return words.stream()
                .filter(s -> s.matches("[A-Za-z]+"))
                .map(word -> word.chars()
                        .mapToObj(c -> (char) c)
                        .map(character -> String.valueOf(Character.toLowerCase(character)))
                        .collect(Collectors.groupingBy(string -> consonants.contains(string) ? "consonants" : "vowels")))
                .collect(Collectors.toList());
    }

    //Дан список строк. Необходимо удалить пустые строки, объединить оставшиеся строки в одну строку, разделенную запятой.
    public static String getJoinedString(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(", "));
    }

    //Дан список слов. Необходимо объединить все символы из всех слов в одну строку.
    public static String getJoinedChars(List<String> strings) {
        return strings.stream().collect(Collectors.joining());
    }

    //Дан список слов. Необходимо проверить, содержат ли они одинаковые символы (являются ли анаграммами) и вывести результат.
    public static boolean isAnagram(List<String> strings) {
        if (strings.isEmpty()) {
            return false;
        }
        char[] chars = strings.get(0).toCharArray();
        Arrays.sort(chars);
        return strings.stream()
                .map(String::toCharArray)
                .allMatch(charsArr -> {
                    Arrays.sort(charsArr);
                    return Arrays.equals(chars, charsArr);
                });
    }

    //Даны два списка чисел. Необходимо найти разность множеств (элементы, присутствующие только в одном из списков) и вывести результат.
    public static List<Integer> getDifferenceOfLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>(list1);
        result.addAll(list2);
        List<Integer> intersection = new ArrayList<>(list1);
        intersection.retainAll(list2);
        result.removeAll(intersection);
        return result;
    }

    //Дан список слов. Необходимо подсчитать количество слов для каждой длины и вывести результат.
    public static Map<Integer, Long> getLengthCount(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
    }

    //Дан список строк. Необходимо отфильтровать строки, которые начинаются с префикса "pre" и заканчиваются суффиксом "post".
    public static List<String> getWordsWithPreAndPost(List<String> strings) {
        return strings.stream()
                .filter(s -> s.startsWith("pre") && s.endsWith("post"))
                .collect(Collectors.toList());
    }

    //Дан список слов. Необходимо подсчитать количество символов в каждом слове и вывести результат.
    public static Map<String, Integer> getCountOfLettersOfWords(List<String> strings) {
        return strings.stream().collect(Collectors.toMap(s -> s, String::length));
    }

    //Дан список чисел. Необходимо найти среднее значение всех уникальных чисел.
    public static double getAvgOfUniqueNumbers(List<Integer> integers) {
        return integers.stream()
                .collect(Collectors.toMap(integer -> integer, value -> 1, Integer::sum))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .mapToInt(i -> i)
                .average()
                .orElse(0.0);
    }

    //Дан список слов. Необходимо найти самое длинное слово с четной длиной.
    public static String getLongestWordWithEvenLength(List<String> strings) {
        return strings.stream()
                .filter(s -> s.length() % 2 == 0)
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }

    //Дан список строк. Необходимо удалить все пробелы в каждой строке, отсортировать их в лексикографическом порядке и вывести результат.
    public static List<String> getSortedStringsWithoutSpaces(List<String> strings) {
        return strings.stream()
                .map(s -> s.replaceAll(" ", ""))
                .sorted()
                .collect(Collectors.toList());
    }

    //Дан список слов. Необходимо проверить, являются ли они палиндромами, и вывести результат.
    public static boolean isPalindromes(List<String> words) {
        if (words.size() % 2 != 0) {
            return false;
        }
        Map<String, String> stringMap = new HashMap<>();
        words.forEach(word -> {
            String wordLoverCase = word.toLowerCase();
            stringMap.put(wordLoverCase, new StringBuilder(wordLoverCase).reverse().toString());
        });

        return stringMap.keySet().equals(new HashSet<>(stringMap.values()));
    }

    //Дан список чисел. Необходимо найти максимальное четное число.
    public static Integer getMaxEvenNumber(List<Integer> integers) {
        return integers.stream()
                .filter(integer -> integer % 2 == 0)
                .max(Comparator.naturalOrder())
                .orElse(null);
    }

    //Дан список строк. Необходимо объединить все строки в одну строку, добавив префикс ">>" и суффикс "<<" к каждой строке.
    public static String transformToStringWithBrackets(List<String> strings) {
        return strings.stream()
                .map(s -> new StringBuilder(">>" + s + "<<"))
                .collect(Collectors.joining());
    }

    //Дан список строк. Необходимо объединить все символы из всех строк, удалить дубликаты и отсортировать их в лексикографическом порядке.
    public static String getUniqueCharacters(List<String> strings) {
        return strings.stream()
                .flatMapToInt(String::chars)
                .distinct()
                .mapToObj(c -> (char) c)
                .sorted(Comparator.comparingInt(Character::toLowerCase))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    //Дан список объектов Person с полем "возраст". Необходимо отфильтровать объекты, возраст которых находится в диапазоне от 25 до 40 лет, отсортировать по имени и вывести результат.
    public static List<Person> getPersonsFrom25To40Sorted(List<Person> personList) {
        return personList.stream()
                .filter(person -> person.getAge() >= 25 && person.getAge() < 40)
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());
    }

    //Дан список чисел. Необходимо найти сумму всех четных чисел, которые являются положительными.
    public static int getSumOfEvenPositiveNumbers(List<Integer> integers) {
        return integers.stream()
                .filter(integer -> integer % 2 == 0 && integer > 0)
                .mapToInt(i -> i)
                .sum();
    }

    //Дан список чисел. Необходимо найти второе минимальное число среди уникальных чисел.
    public static Integer getSecondMinimalOfUniqueNumbers(List<Integer> integers) {
        return integers.stream()
                .collect(Collectors.toMap(integer -> integer, value -> 1, Integer::sum))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(null);
    }

    //Дан список слов. Необходимо разделить их на две группы: одна группа - слова с длиной менее или равной 4 символам, другая группа - слова с длиной более 4 символов. После этого подсчитать количество слов в каждой группе и вывести результат.
    public static Map<String, Long> getCountOfWordsGroupedByLength(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(word -> word.length() <= 4 ? "length <= 4" : "length > 4", Collectors.counting()));
    }

    //Дан список строк. Необходимо пропустить первые три символа в каждой строке и объединить оставшиеся символы в одну строку.
    public static String getJoinedStringWithoutFirst3Letters(List<String> strings) {
        return strings.stream()
                .filter(s -> s.length() > 3)
                .map(s -> s.substring(3))
                .collect(Collectors.joining());
    }

    //Дан список чисел. Необходимо найти три наименьших числа и вывести результат.
    public static List<Integer> get3MinNumbers(List<Integer> integers) {
        return integers.stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
    }

    //Дан список строк. Необходимо проверить, содержит ли хотя бы одна строка подстроку "an" и вывести результат.
    public static boolean isContainsString(List<String> strings) {
        return strings.stream()
                .anyMatch(s -> s.contains("an"));
    }
}