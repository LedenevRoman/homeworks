package com.telrun.rledenev._2023_08_22;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ProductStorageJsonParser {
    private static final String JSON_FILE_NAME = "src/main/java/com/telrun/rledenev/_2023_08_22/report.json";

    public static ProductStorage addProductsToStorageFromJsonFile(ProductStorage productStorage) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(JSON_FILE_NAME));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
