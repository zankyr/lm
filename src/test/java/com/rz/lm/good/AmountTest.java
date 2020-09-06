package com.rz.lm.good;

import com.rz.lm.Good;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AmountTest {

    @Test
    public void whenTaxFreeGood_thenAmountShouldBeCorrect() {
        // given
        Good book = Good.taxFree("book", BigDecimal.valueOf(12.49));

        // then
        assertEquals(new BigDecimal("12.49"), book.getAmount());
    }

    @Test
    public void whenTaxedGood_thenAmountShouldBeCorrect() {
        // given
        Good musicCD = Good.taxed("music cd", BigDecimal.valueOf(14.99));

        // when
        assertEquals(new BigDecimal("16.49"), musicCD.getAmount());
    }

    @Test
    public void whenImportedTaxFreeGood_thenAmountShouldBeCorrect() {
        // given
        Good importedTaxFreeGood = Good.importedTaxFree("box of choco", BigDecimal.valueOf(10.00));

        // when
        assertEquals(new BigDecimal("10.50"), importedTaxFreeGood.getAmount());
    }

    @Test
    public void whenImportedTaxedGood_thenAmountShouldBeCorrect() {
        // given
        Good importedTaxedGood = Good.importedTaxed("parfume", BigDecimal.valueOf(47.50));

        // then
        assertEquals(new BigDecimal("54.65"), importedTaxedGood.getAmount());
    }

}
