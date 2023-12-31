package com.telrun.rledenev.summary_0630.Classwork;

import java.util.*;

public class CodingProblems {
    public static void main(String[] args) {
    }

    // 0. Спроектировать очередь с одним произвольным элементом.
    // метод add(elem) добавляет элемент
    // метод get() возвращает элемент
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
    // Пример использования:
    // OneQueue<Integer> q = new OneQueue<>();
    // q.add(1); соддержит элемент 1
    // q.add(2) удаляет 1 и содержит 2
    // q.get() возвращает 2
    // q.add(1).add(2) и после этого q.get() в итоге содержит 2


    // 1. Спроектируйте класс для управления задачами. В нем должен быть метод по добавлению задачи с приоритетом
    // и получения самой приоритетной задачи (с её удалением)

    // Примечание:
    // а) Приоритет - целое число. Чем оно больше тем приоритет выше.
    // б) Задача представляет собой класс Task с одним полем "String name". Приоритет не является составной частью задачи
    // и передаётся отдельно

    // 2. Нужно написать модуль программы по составлению отчета по продажам за выбранные даты.
    // Продажа представляет собой: артикул, количество и стоимость.
    // Отчет должен отображать: самый продаваемый артикул и общую стоимость всех продаж по каждому артикулу.
    // Желаемый интерфейс:
    //
    // ReportGenerator {
    //  ReportResult generateReport(ZonedDateTime from, ZoneDateTime to);
    // }

    // Примечание:
    // а) при этом выгрузкой информации по продажам занимается другая команда, которая пока ещё не передала вам
    // информацию как в вашем модуле получать сами заказы. Обойдите это ограничение.
    // б) ZonedDateTime можно создать с помощью:
    //  LocalDate.parse("2023-06-01").atStartOfDay(ZoneId.of("Europe/Berlin"));

    // 3. Даны две строки s и t. Нужно проверить что строка s является анаграммой строки t.
    // Строка является анаграммой другой строки когда символы первой строки можно переставить таким образом, чтобы
    // получилась другая строка.
    // Пример: "abc" является анаграммой для "bac"
    // Пример: "abc" не является анаграммой для "ca" (отсутствует символ 'b')

    // 3. Даны два отсортированных массива размера n и m. Нужно создать новый массив n+m из элементов первых двух
    // так же в отсортированном порядке.
}
