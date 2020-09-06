package com.rz.lm.input_test;

import com.rz.lm.Basket;
import com.rz.lm.Good;
import com.rz.lm.Receipt;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class Input4Test {
    @Test
    public void whenMultipleGoodsOfSameType_resultShoudBeCorrect() {
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

        // duplicate the goods
        basket.addGood(importedParfume);
        basket.addGood(parfume);
        basket.addGood(headachePills);
        basket.addGood(importedChoco);

        // when
        String result = new Receipt(basket).print();

        // then
        String expected = "2 imported bottle of perfume: 64.38\n" +
                "2 bottle of perfume: 41.78\n" +
                "2 packet of headache pills: 19.50\n" +
                "2 imported box of chocolates: 23.70\n" +
                "Sales Taxes: 13.40\n" +
                "Total: 149.36";

        assertEquals(expected, result);


    }
}
