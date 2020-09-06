package com.rz.lm.input_test;

import com.rz.lm.Basket;
import com.rz.lm.Good;
import com.rz.lm.Receipt;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Input2Test {
    @Test
    void givenInput2_resultShoudBeCorrect() {
        // given
        Good importedChoco = Good.importedTaxFree("imported box of chocolates", BigDecimal.valueOf(10));
        Good importedParfume = Good.importedTaxed("imported bottle of perfume", BigDecimal.valueOf(47.50));

        Basket basket = new Basket();
        basket.addGood(importedChoco);
        basket.addGood(importedParfume);

        // when
        String result = new Receipt(basket).print();

        // then
        String expected = "1 imported box of chocolates: 10.50\n" +
                "1 imported bottle of perfume: 54.65\n" +
                "Sales Taxes: 7.65\n" +
                "Total: 65.15";

        assertEquals(expected, result);


    }
}
