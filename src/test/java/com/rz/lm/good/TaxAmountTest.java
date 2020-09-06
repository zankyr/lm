package com.rz.lm.good;

import com.rz.lm.Good;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaxAmountTest {

    @Test
    void whenTaxFreeGood_taxesShouldBeZero() {
        // given
        Good good = Good.taxFree("good", BigDecimal.valueOf(10.00));

        // then
        assertEquals(new BigDecimal("0.00"), good.getTaxes());
    }

    @Test
    void whenTaxesGood_taxesShouldBeCorrect() {
        // given
        Good good = Good.taxed("good", BigDecimal.valueOf(10.00));

        // then
        assertEquals(new BigDecimal("1.00"), good.getTaxes());
    }

    @Test
    void whenImportedTaxFreeGood_taxesShouldBeCorrect() {
        // given
        Good good = Good.importedTaxFree("good", BigDecimal.valueOf(10.00));

        // then
        assertEquals(new BigDecimal("0.50"), good.getTaxes());
    }

    @Test
    void whenImportedTaxedGood_taxesShouldBeCorrect() {
        // given
        Good good = Good.importedTaxed("good", BigDecimal.valueOf(10.00));

        // then
        assertEquals(new BigDecimal("1.50"), good.getTaxes());
    }
}
