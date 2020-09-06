package com.rz.lm;

import java.math.BigDecimal;

public class Receipt {
    private Basket basket;

    private Receipt() {
    }

    public Receipt(Basket basket) {
        this.basket = basket;
    }

    public String print() {
        if (basket == null || basket.getGoods().isEmpty()) {
            // This will be handled with a dedicated ex
            throw new RuntimeException("Empty/non valid basket");
        }

        StringBuilder sb = new StringBuilder();
        basket.getGoods().forEach((key, value) -> {
            sb.append(value);
            sb.append(" ");
            sb.append(key.getName());
            sb.append(": ");
            sb.append(key.getAmount().multiply(new BigDecimal(value)));
            sb.append("\n");
        });

        sb.append("Sales Taxes: ");
        sb.append(basket.getSalesTaxes());
        sb.append("\n");

        sb.append("Total: ");
        sb.append(basket.getTotal());

        return sb.toString();
    }
}
