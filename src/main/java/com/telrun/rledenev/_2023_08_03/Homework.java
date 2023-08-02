package com.telrun.rledenev._2023_08_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {
        String emails = "john.doe@example.com\n" +
                "jane.smith.@example.org\n" +
                "james.bond@example.com\n" +
                "jane.smith@example.org\n" +
                "jane.smith@example.net";

        String urls = "http://www.example.com\n" +
                "http://www.example.org\n" +
                "https://www.example.net\n" +
                "http://www.example.com/about";

        String products = "ABC123:5\n" +
                "XYZ789:12\n" +
                "DEF456:8\n" +
                "JKL012:15\n" +
                "MNO345:6";

        System.out.println(getDomainCountMap(emails));
        System.out.println(replaceHttpToHttpsInURL(urls));
        System.out.println(getProductsWitchHaveQuantityMoreThan10(products));

    }

    /**
     * Вам дан текстовый файл, содержащий список email-адресов.
     * Извлечь все уникальные домены электронной почты и подсчитать,
     * сколько раз каждый домен встречается в списке.
     */
    public static Map<String, Long> getDomainCountMap(String emails) {
        List<String> emailsList = new ArrayList<>();

        Pattern pattern = Pattern
                .compile("(?!.*\\.{2})[A-Za-z0-9][A-Za-z0-9.]{4,28}[A-Za-z0-9]@[A-Za-z0-9.]+\\.[A-Za-z]{2,}");
        Matcher matcher = pattern.matcher(emails);

        while (matcher.find()) {
            String email = emails.substring(matcher.start(), matcher.end());
            emailsList.add(email);
        }

        return emailsList.stream()
                .map(Homework::getDomain)
                .collect(Collectors.groupingBy(domain -> domain, Collectors.counting()));
    }

    private static String getDomain(String email) {
        String[] nameDomainArray = email.split("@");
        return nameDomainArray[1];
    }

    /**
     * Вам дан текстовый файл, содержащий список URL-адресов.
     * Найти все URL, которые содержат протокол "https://" и заменить их на "http://"
     * без использования методов replace().
     */
    public static String replaceHttpToHttpsInURL(String urls) {
        StringBuilder stringBuilder = new StringBuilder(urls);

        Pattern pattern = Pattern.compile("http://");
        Matcher matcher = pattern.matcher(stringBuilder);

        while (matcher.find()) {
            stringBuilder.insert(matcher.start() + 4, "s");
        }
        return stringBuilder.toString();
    }

    /**
     * Вам дан текстовый файл, содержащий список кодов продуктов в формате: <product_code>:<quantity>.
     * Найти все продукты с количеством больше 10 и вывести их коды и количество.
     */
    public static Map<String, Integer> getProductsWitchHaveQuantityMoreThan10(String products) {
        Map<String, Integer> productQuantityMap = new HashMap<>();

        Pattern pattern = Pattern.compile("\\w+:\\d+");
        Matcher matcher = pattern.matcher(products);

        while (matcher.find()) {
            String[] productQuantityArray = products.substring(matcher.start(), matcher.end())
                    .split(":");
            int quantity = Integer.parseInt(productQuantityArray[1]);
            if (quantity > 10) {
                productQuantityMap.put(productQuantityArray[0], quantity);
            }
        }

        return productQuantityMap;
    }
}
