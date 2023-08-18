package com.telrun.rledenev.summary_0818.task2;

public class Finder {
    /**    // Дизайн ООП
     // На вход дан CSV файл. Требуется написать модуль, который индексирует этот файл и предоставляет метод для поиска
     // индекса по значению
     // RowIndex find(fieldName: String, value: String)
     // , где RowIndex = Integer
     //
     */

    private final ParsedCsv parsedCsv;

    public Finder(ParsedCsv parsedCsv) {
        this.parsedCsv = parsedCsv;
    }

    public Integer find(String fieldName, String value) {
        return parsedCsv.getParsedData().get(fieldName).get(value);
    }
}
