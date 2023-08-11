package com.telrun.rledenev.summary_0714.task;

import java.math.BigDecimal;

public class Check {
    private final String article;
    private final int count;
    private final BigDecimal overallPrice;

    public Check(String article, int count, BigDecimal price) {
        this.article = article;
        this.count = count;
        this.overallPrice = price;
    }

    public String getArticle() {
        return article;
    }

    public int getCount() {
        return count;
    }

    public BigDecimal getOverallPrice() {
        return overallPrice;
    }

    @Override
    public String toString() {
        return "Check{" +
                "article='" + article + '\'' +
                ", count=" + count +
                ", price=" + overallPrice +
                '}';
    }
}
