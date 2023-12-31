package com.telrun.rledenev._2023_08_22;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public final class ProductStorageJsonParser {

    private ProductStorageJsonParser() {
    }

    public static void addProductsToStorageFromJsonFile(String jsonFilePath, ProductStorage productStorage) {
        String json = readJsonFromFile(jsonFilePath);
        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Product product = parseJsonObjectToProduct(jsonObject);
            productStorage.addProduct(product);
        }
    }

    private static Product parseJsonObjectToProduct(JSONObject jsonObject) {
        Product product = new Product();
        String[] categoryAndIdArray = jsonObject.getString("CATEGORY").split("#");
        String idString = categoryAndIdArray[1];
        product.setId(Long.parseLong(idString));
        product.setCategory(categoryAndIdArray[0]);
        product.setName(jsonObject.getString("NAME").replace("#" + idString, ""));
        product.setFactory(jsonObject.getString("FACTORY").replace("#" + idString, ""));
        product.setQuantity(jsonObject.getInt("QUANTITY"));
        product.setIsPacked(jsonObject.getBoolean("ISPACKED"));
        product.setIsAdv(jsonObject.getBoolean("ISADV"));
        product.setPrice(BigDecimal.valueOf(jsonObject.getDouble("PRICE")));
        product.setMargin(BigDecimal.valueOf(jsonObject.getDouble("MARGIN")));
        product.setIsDebt(jsonObject.getBoolean("ISDEBT"));
        return product;
    }

    private static String readJsonFromFile(String jsonFilePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new IllegalArgumentException("File not found with name " + jsonFilePath);
        }
    }
}
