package com.telrun.rledenev._2023_08_22;

public class Main {
    public static void main(String[] args) {
        ProductStorage productStorage = new ProductStorage();
        ProductStorageJsonParser.addProductsToStorageFromJsonFile(productStorage);
        System.out.println(productStorage);
        System.out.println(productStorage.getIdsOfProducts());
        System.out.println(productStorage.getMostExpensiveSnack());
        System.out.println(productStorage.getProductWhichIsMostInTermsOfMoney());
        System.out.println(productStorage.getDrinksWhichIsSmallestInTermsOfMoney());
        System.out.println(productStorage.countOfFoodAdv());
        System.out.println(productStorage.groupingByIsPacked());
        System.out.println(productStorage.getMostMarginDrinks());
        System.out.println(productStorage.getAvgMarginByCategory());
        System.out.println(productStorage.getThreeCheapestFoodIsAdv());
        System.out.println(productStorage.getTreeMapIdProduct());
    }
}
