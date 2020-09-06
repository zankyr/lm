package com.rz.lm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import static com.rz.lm.utils.TaxUtils.calculateRoundedTaxAmount;

public class Good {
    private static final BigDecimal TAX_FREE_RATE = BigDecimal.valueOf(0.00);
    private static final BigDecimal BASIC_SALES_TAX = BigDecimal.valueOf(10.00);
    private static final BigDecimal IMPORT_SALES_TAX = BigDecimal.valueOf(5.00);

    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    private final BigDecimal amount;
    private final BigDecimal taxes;

    private final String name;

    private Good(String name, BigDecimal price, BigDecimal basicSalesTax) {
        this.name = name;

        taxes = calculateRoundedTaxAmount(price, basicSalesTax);

        this.amount = price.add(taxes).setScale(2, ROUNDING_MODE);
    }

    private Good(String name, BigDecimal price, BigDecimal taxRate, BigDecimal importSalesTax) {
        this.name = name;

        price = price.setScale(2, ROUNDING_MODE);

        BigDecimal basicSalesTaxAmount = calculateRoundedTaxAmount(price, taxRate);
        BigDecimal importSalesTaxAmount = calculateRoundedTaxAmount(price, importSalesTax);

        taxes = basicSalesTaxAmount.add(importSalesTaxAmount);

        this.amount = price.add(taxes);

    }

    public static Good taxFree(String name, BigDecimal price) {
        return new Good(name, price, TAX_FREE_RATE);
    }

    public static Good taxed(String name, BigDecimal price) {
        return new Good(name, price, BASIC_SALES_TAX);
    }

    public static Good importedTaxFree(String name, BigDecimal price) {
        return new Good(name, price, TAX_FREE_RATE, IMPORT_SALES_TAX);
    }

    public static Good importedTaxed(String name, BigDecimal price) {
        return new Good(name, price, BASIC_SALES_TAX, IMPORT_SALES_TAX);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getTaxes() {
        return taxes;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return Objects.equals(amount, good.amount) &&
                Objects.equals(taxes, good.taxes) &&
                Objects.equals(name, good.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, taxes, name);
    }
}
