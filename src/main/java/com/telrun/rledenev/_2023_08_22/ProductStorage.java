package com.telrun.rledenev._2023_08_22;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ProductStorage {
    private final Set<Product> productsDataBase = new HashSet<>();

    public void addProduct(Product product) {
        checkProduct(product);
        productsDataBase.add(product);
    }

    public Set<Long> getIdsOfProducts() {
        return productsDataBase.stream()
                .map(Product::getId)
                .collect(Collectors.toSet());
    }

    public Product getMostExpensiveSnack() {
        return productsDataBase.stream()
                .filter(product -> product.getCategory().equals("SNACKS"))
                .max(Comparator.comparing(Product::getPrice))
                .orElse(null);
    }

    public Product getProductWhichIsMostInTermsOfMoney() {
        return productsDataBase.stream()
                .max(Comparator.comparing(product ->
                        product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity()))))
                .orElse(null);
    }

    public Product getDrinksWhichIsSmallestInTermsOfMoney() {
        return productsDataBase.stream()
                .filter(product -> product.getCategory().equals("DRINKS"))
                .min(Comparator.comparing(product ->
                        product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity()))))
                .orElse(null);
    }

    public Long countOfFoodAdv() {
        return productsDataBase.stream()
                .filter(product -> product.getCategory().equals("FOOD") && product.getIsAdv())
                .count();
    }

    public Map<Boolean, Set<Product>> groupingByIsPacked() {
        return productsDataBase.stream()
                .collect(Collectors.partitioningBy(Product::getIsPacked, Collectors.toSet()));
    }

    public Product getMostMarginDrinks() {
        return productsDataBase.stream()
                .filter(product -> product.getCategory().equals("DRINKS"))
                .max(Comparator.comparing(Product::getMargin))
                .orElse(null);
    }

    public Map<String, Double> getAvgMarginByCategory() {
        return productsDataBase.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.averagingDouble(product -> product.getMargin().doubleValue())));
    }

    public List<Product> getThreeCheapestFoodIsAdv() {
        return productsDataBase.stream()
                .filter(product -> product.getCategory().equals("FOOD") && product.getIsAdv())
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(3)
                .collect(Collectors.toList());
    }

    public NavigableMap<Long, Product> getTreeMapIdProduct() {
        return productsDataBase.stream()
                .collect(Collectors.toMap(Product::getId, product -> product,
                        (oldValue, newValue) -> newValue, TreeMap::new));
    }

    private static void checkProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("product is null");
        }
        if (product.getId() == null || product.getId() <= 0) {
            throw new IllegalArgumentException("field id is incorrect");
        }
    }
}
