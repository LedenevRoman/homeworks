package com.telrun.rledenev.summary_0818.task2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class CsvReader {
    private CsvReader() {
    }

    public static ParsedCsv readCsvFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath)))) {
            Map<String, Map<String, Integer>> parsedData = new HashMap<>();
            String[] header = reader.readLine().split(",");

            for (String s : header) {
                parsedData.put(s, new HashMap<>());

            }

            int rowIndex = 0;
            while (reader.ready()) {
                String dataLine = reader.readLine();
                if (dataLine.isEmpty()) {
                    break;
                }
                String[] dataParts = dataLine.split(",");
                for (int i = 0; i < dataParts.length; i++) {
                    parsedData.get(header[i]).put(dataParts[i], rowIndex);
                }
                rowIndex++;
            }

            return new ParsedCsv(parsedData);
        } catch (IOException e) {
            throw new IncorrectPathException();
        }
    }
}
