package com.telrun.rledenev.summary_1407.task;

import java.math.BigDecimal;
import java.util.Map;

public class ReportResult {
    /**
     *  ReportResult должен отображать: самый продаваемый артикул и общую стоимость всех продаж по каждому артикулу.
     */
    private final String article;
    private final Map<String, BigDecimal> prices;

    public ReportResult(String article, Map<String, BigDecimal> prices) {
        this.article = article;
        this.prices = prices;
    }

    public String getArticle() {
        return article;
    }

    public Map<String, BigDecimal> getPrices() {
        return prices;
    }

    @Override
    public String toString() {
        return "ReportResult{" +
                "article='" + article + '\'' +
                ", prices=" + prices +
                '}';
    }
}
