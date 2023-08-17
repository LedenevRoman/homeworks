package com.telrun.rledenev._2023_08_22;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
public class Product {
    private Long id;
    private String category;
    private String name;
    private String factory;
    private String quantity;
    private Boolean isPacked;
    private Boolean isAdv;
    private BigDecimal price;
    private BigDecimal margin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id)
                && Objects.equals(category, product.category)
                && Objects.equals(name, product.name)
                && Objects.equals(factory, product.factory)
                && Objects.equals(quantity, product.quantity)
                && Objects.equals(isPacked, product.isPacked)
                && Objects.equals(isAdv, product.isAdv)
                && Objects.equals(price, product.price)
                && Objects.equals(margin, product.margin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, name, factory, quantity, isPacked, isAdv, price, margin);
    }
}
