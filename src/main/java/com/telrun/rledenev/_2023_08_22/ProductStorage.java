package com.telrun.rledenev._2023_08_22;

import java.util.HashSet;
import java.util.Set;

public class ProductStorage {
    private Set<Product> productsDataBase = new HashSet<>();

    public boolean addProduct(Product product) {
        checkProduct(product);
        return productsDataBase.add(product);
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
