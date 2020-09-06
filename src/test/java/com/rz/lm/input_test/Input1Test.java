package com.rz.lm.input_test;

import com.rz.lm.Basket;
import com.rz.lm.Good;
import com.rz.lm.Receipt;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class Input1Test {
    @Test
    public void givenInput1_resultShoudBeCorrect() {
        // given
        Good book = Good.taxFree("book", BigDecimal.valueOf(12.49));
        Good musicCD = Good.taxed("music CD", BigDecimal.valueOf(14.99));
        Good chocoBar = Good.taxFree("chocolate bar", BigDecimal.valueOf(0.85));

        Basket basket = new Basket();
        basket.addGood(book);
        basket.addGood(musicCD);
        basket.addGood(chocoBar);

        // when
        String result = new Receipt(basket).print();

        // then
        String expected = "1 book: 12.49\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 29.83";

        assertEquals(expected, result);


    }
}
