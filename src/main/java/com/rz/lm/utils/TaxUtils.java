package com.rz.lm.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxUtils {
    private TaxUtils() {
    }

    public static BigDecimal calculateRoundedTaxAmount(BigDecimal amount, BigDecimal taxRate) {
        return round(getTaxAmount(amount, taxRate, RoundingMode.UP), new BigDecimal("0.05"), RoundingMode.UP);
    }

    private static BigDecimal getTaxAmount(BigDecimal amount, BigDecimal taxRate, RoundingMode roundingMode) {
        return amount.multiply(taxRate).divide(new BigDecimal(100), 2, roundingMode);
    }

    public static BigDecimal round(BigDecimal value,
                                   BigDecimal increment,
                                   RoundingMode roundingMode) {
        if (increment.signum() == 0) {
            // prevent division by 0
            return value;
        } else {
            BigDecimal divided = value.divide(increment, 0, roundingMode);
            return divided.multiply(increment);
        }
    }
}
