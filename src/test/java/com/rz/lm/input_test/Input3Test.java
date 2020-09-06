package com.rz.lm.input_test;

import com.rz.lm.Basket;
import com.rz.lm.Good;
import com.rz.lm.Receipt;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Input3Test {
    @Test
    void givenInput3_resultShoudBeCorrect() {
        // given
        Good importedParfume = Good.importedTaxed("imported bottle of perfume", BigDecimal.valueOf(27.99));
        Good parfume = Good.taxed("bottle of perfume", BigDecimal.valueOf(18.99));
        Good headachePills = Good.taxFree("packet of headache pills", BigDecimal.valueOf(9.75));
        Good importedChoco = Good.importedTaxFree("imported box of chocolates", BigDecimal.valueOf(11.25));

        Basket basket = new Basket();
        basket.addGood(importedParfume);
        basket.addGood(parfume);
        basket.addGood(headachePills);
        basket.addGood(importedChoco);

        // when
        String result = new Receipt(basket).print();

        // then
        String expected = "1 imported bottle of perfume: 32.19\n" +
                "1 bottle of perfume: 20.89\n" +
                "1 packet of headache pills: 9.75\n" +
                "1 imported box of chocolates: 11.85\n" +
                "Sales Taxes: 6.70\n" +
                "Total: 74.68";

        assertEquals(expected, result);


    }
}
