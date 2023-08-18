package com.telrun.rledenev.summary_0818.task2;

public class FinderCreator {

    public static Finder createFinder(String filePath) {
        ParsedCsv parsedCsv = CsvReader.readCsvFile(filePath);
        return new Finder(parsedCsv);
    }
}
