package com.telrun.rledenev._2023_08_22;

import org.json.JSONException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductStorageTest {
    private static final String VALID_FILE_PATH = "src/test/java/com/telrun/rledenev/_2023_08_22/reportTest.json";
    private static final String VALID_SHORT_FILE_PATH =
            "src/test/java/com/telrun/rledenev/_2023_08_22/shortReportTest.json";
    private static final String INVALID_FILE_PATH = "com/telrun/rledenev/_2023_08_22/reportTest.json";
    private static final String NOT_CORRECT_JSON_FILE_PATH = "src/test/java/com/telrun/rledenev/_2023_08_22/hwTest.txt";
    private ProductStorage productStorage;

    @BeforeEach
    void setUp() {
        productStorage = new ProductStorage();
    }

    @AfterEach
    void tearDown() {
        productStorage = null;
    }

    @Test
    void addProductNegativeCaseTest() {
        Product nullIdProduct = new Product();
        nullIdProduct.setId(null);
        Product subZeroIdProduct = new Product();
        subZeroIdProduct.setId(-1L);

        assertThrows(IllegalArgumentException.class, () -> productStorage.addProduct(null));
        assertThrows(IllegalArgumentException.class, () -> productStorage.addProduct(nullIdProduct));
        assertThrows(IllegalArgumentException.class, () -> productStorage.addProduct(subZeroIdProduct));
    }

    @Test
    void negativeParseJsonTest() {
        assertThrows(IllegalArgumentException.class, () -> ProductStorageJsonParser
                .addProductsToStorageFromJsonFile(INVALID_FILE_PATH, productStorage));
        assertThrows(JSONException.class, () -> ProductStorageJsonParser
                .addProductsToStorageFromJsonFile(NOT_CORRECT_JSON_FILE_PATH, productStorage));
    }

    @Test
    void getIdsOfProductsTest() {
        ProductStorageJsonParser.addProductsToStorageFromJsonFile(VALID_SHORT_FILE_PATH, productStorage);
        Set<Long> expected = new HashSet<>();
        expected.add(1L);
        expected.add(2L);
        expected.add(3L);
        expected.add(4L);
        expected.add(5L);
        expected.add(6L);
        assertEquals(expected, productStorage.getIdsOfProducts());
    }

    @Test
    void getMostExpensiveSnackTest() {
        ProductStorageJsonParser.addProductsToStorageFromJsonFile(VALID_SHORT_FILE_PATH, productStorage);
        Product expected = new Product();
        expected.setId(6L);
        expected.setCategory("SNACKS");
        expected.setName("Mixed Nuts");
        assertEquals(expected, productStorage.getMostExpensiveSnack());
    }

    @Test
    void getProductWhichIsMostInTermsOfMoneyTest() {
        ProductStorageJsonParser.addProductsToStorageFromJsonFile(VALID_SHORT_FILE_PATH, productStorage);
        Product expected = new Product();
        expected.setId(5L);
        expected.setCategory("DRINKS");
        expected.setName("Iced Tea");
        assertEquals(expected, productStorage.getProductWhichIsMostInTermsOfMoney());
    }

    @Test
    void getDrinksWhichIsSmallestInTermsOfMoneyTest() {
        ProductStorageJsonParser.addProductsToStorageFromJsonFile(VALID_SHORT_FILE_PATH, productStorage);
        Product expected = new Product();
        expected.setId(2L);
        expected.setCategory("DRINKS");
        expected.setName("Mineral Water");
        assertEquals(expected, productStorage.getDrinksWhichIsSmallestInTermsOfMoney());
    }

    @Test
    void countOfFoodAdvTest() {
        ProductStorageJsonParser.addProductsToStorageFromJsonFile(VALID_SHORT_FILE_PATH, productStorage);
        assertEquals(1, productStorage.countOfFoodAdv());
    }

    @Test
    void groupingByIsPackedTest() {
        ProductStorageJsonParser.addProductsToStorageFromJsonFile(VALID_SHORT_FILE_PATH, productStorage);
        Map<Boolean, Set<Product>> expected = new HashMap<>();
        Set<Product> trueSet = getPackedProductsSet();
        Set<Product> falseSet = getNotPackedProductsSet();
        expected.put(true, trueSet);
        expected.put(false, falseSet);
        assertEquals(expected, productStorage.groupingByIsPacked());
    }

    @Test
    void getMostMarginDrinksTest() {
        ProductStorageJsonParser.addProductsToStorageFromJsonFile(VALID_SHORT_FILE_PATH, productStorage);
        Product expected = new Product();
        expected.setId(2L);
        expected.setCategory("DRINKS");
        expected.setName("Mineral Water");
        assertEquals(expected, productStorage.getMostMarginDrinks());
    }

    @Test
    void getAvgMarginByCategoryTest() {
        ProductStorageJsonParser.addProductsToStorageFromJsonFile(VALID_SHORT_FILE_PATH, productStorage);
        Map<String, Double> expected = new HashMap<>();
        expected.put("DRINKS", 19.0);
        expected.put("SNACKS", 20.25);
        expected.put("FOOD", 15.0);
        assertEquals(expected, productStorage.getAvgMarginByCategory());
    }

    @Test
    void getThreeCheapestFoodIsAdvTest() {
        ProductStorageJsonParser.addProductsToStorageFromJsonFile(VALID_FILE_PATH, productStorage);
        List<Product> expected = new ArrayList<>();
        Product product1 = new Product();
        product1.setId(187L);
        product1.setCategory("FOOD");
        product1.setName("Canned Fruit");
        Product product2 = new Product();
        product2.setId(43L);
        product2.setCategory("FOOD");
        product2.setName("Canned Fruit");
        Product product3 = new Product();
        product3.setId(112L);
        product3.setCategory("FOOD");
        product3.setName("Canned Fruit");

        expected.add(product1);
        expected.add(product2);
        expected.add(product3);

        assertEquals(expected, productStorage.getThreeCheapestFoodIsAdv());
    }

    @Test
    void getTreeMapIdProductTest() {
        ProductStorageJsonParser.addProductsToStorageFromJsonFile(VALID_SHORT_FILE_PATH, productStorage);
        NavigableMap<Long, Product> expected = getIdProductTreeMap();
        assertEquals(expected, productStorage.getTreeMapIdProduct());
    }

    private static NavigableMap<Long, Product> getIdProductTreeMap() {
        NavigableMap<Long, Product> expected = new TreeMap<>();
        Product product1 = new Product();
        product1.setId(1L);
        product1.setCategory("FOOD");
        product1.setName("Pasta");
        Product product2 = new Product();
        product2.setId(2L);
        product2.setCategory("DRINKS");
        product2.setName("Mineral Water");
        Product product5 = new Product();
        product5.setId(5L);
        product5.setCategory("DRINKS");
        product5.setName("Iced Tea");
        Product product6 = new Product();
        product6.setId(6L);
        product6.setCategory("SNACKS");
        product6.setName("Mixed Nuts");
        Product product3 = new Product();
        product3.setId(3L);
        product3.setCategory("SNACKS");
        product3.setName("Potato Chips");
        Product product4 = new Product();
        product4.setId(4L);
        product4.setCategory("FOOD");
        product4.setName("Chocolate Bar");
        expected.put(1L, product1);
        expected.put(2L, product2);
        expected.put(3L, product3);
        expected.put(4L, product4);
        expected.put(5L, product5);
        expected.put(6L, product6);
        return expected;
    }

    private static Set<Product> getNotPackedProductsSet() {
        Set<Product> falseSet = new HashSet<>();
        Product falseProduct1 = new Product();
        falseProduct1.setId(3L);
        falseProduct1.setCategory("SNACKS");
        falseProduct1.setName("Potato Chips");
        Product falseProduct2 = new Product();
        falseProduct2.setId(4L);
        falseProduct2.setCategory("FOOD");
        falseProduct2.setName("Chocolate Bar");
        falseSet.add(falseProduct1);
        falseSet.add(falseProduct2);
        return falseSet;
    }

    private static Set<Product> getPackedProductsSet() {
        Set<Product> trueSet = new HashSet<>();
        Product trueProduct1 = new Product();
        trueProduct1.setId(1L);
        trueProduct1.setCategory("FOOD");
        trueProduct1.setName("Pasta");
        Product trueProduct2 = new Product();
        trueProduct2.setId(2L);
        trueProduct2.setCategory("DRINKS");
        trueProduct2.setName("Mineral Water");
        Product trueProduct3 = new Product();
        trueProduct3.setId(5L);
        trueProduct3.setCategory("DRINKS");
        trueProduct3.setName("Iced Tea");
        Product trueProduct4 = new Product();
        trueProduct4.setId(6L);
        trueProduct4.setCategory("SNACKS");
        trueProduct4.setName("Mixed Nuts");
        trueSet.add(trueProduct1);
        trueSet.add(trueProduct2);
        trueSet.add(trueProduct3);
        trueSet.add(trueProduct4);
        return trueSet;
    }
}