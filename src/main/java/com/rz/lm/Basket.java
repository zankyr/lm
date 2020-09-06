package com.rz.lm;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Basket {
    private final Map<Good, Integer> goods = new LinkedHashMap<>();
    private BigDecimal total = BigDecimal.valueOf(0.00);
    private BigDecimal salesTaxes = BigDecimal.valueOf(0.00);

    public void addGood(Good good) {
        if (good == null) {
            // This will be handled with a dedicated ex
            throw new RuntimeException("Empty/non valid Good");
        }

        goods.merge(good, 1, Integer::sum);

        salesTaxes = salesTaxes.add(good.getTaxes());
        total = total.add(good.getAmount());
    }

    public Map<Good, Integer> getGoods() {
        return goods;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public BigDecimal getSalesTaxes() {
        return salesTaxes;
    }
}
