package com.rz.lm;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.rz.lm.utils.TaxUtils.round;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxUtilsTest {
    @Test
    void roundTest() {
        assertEquals(new BigDecimal("0.05"), round(new BigDecimal("0.03"), new BigDecimal("0.05"), RoundingMode.UP));
        assertEquals(new BigDecimal("2.40"), round(new BigDecimal("2.38"), new BigDecimal("0.05"), RoundingMode.UP));
        assertEquals(new BigDecimal("0.60"), round(new BigDecimal("0.56"), new BigDecimal("0.05"), RoundingMode.UP));
    }
}
