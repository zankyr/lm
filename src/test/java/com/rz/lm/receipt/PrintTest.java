package com.rz.lm.receipt;

import com.rz.lm.Basket;
import com.rz.lm.Good;
import com.rz.lm.Receipt;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class PrintTest {
    @Test(expected = Exception.class)
    public void whenPrint_ifBasketIsEmpty_thenThrowException() {
        // when
        new Receipt(new Basket()).print();
    }

    @Test
    public void whenPrint_outputShouldBeExpected() {
        // given
        Good given = Good.taxFree("good name", BigDecimal.valueOf(1.00));
        Basket basket = new Basket();
        basket.addGood(given);
        Receipt receipt = new Receipt(basket);
        String expected = "1 good name: 1.00\nSales Taxes: 0.00\nTotal: 1.00";

        // when
        String result = receipt.print();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenPrintWithMultipleItems_outputShouldBeExpected() {
        // given
        Basket basket = new Basket();
        Good given1 = Good.taxFree("item name 1", BigDecimal.valueOf(1.00));
        basket.addGood(given1);

        Good given2 = Good.taxFree("item name 2", BigDecimal.valueOf(1.00));
        basket.addGood(given2);

        Receipt receipt = new Receipt(basket);
        String expected = "1 item name 1: 1.00\n1 item name 2: 1.00\nSales Taxes: 0.00\nTotal: 2.00";

        // when
        String result = receipt.print();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenPrintWithMultipleItemsOfSameType_outputShouldBeExpected() {
        // given
        Basket basket = new Basket();
        Good given1 = Good.taxFree("item name 1", BigDecimal.valueOf(1.00));
        basket.addGood(given1);

        Good given2 = Good.taxFree("item name 1", BigDecimal.valueOf(1.00));
        basket.addGood(given2);

        Receipt receipt = new Receipt(basket);
        String expected = "2 item name 1: 2.00\nSales Taxes: 0.00\nTotal: 2.00";

        // when
        String result = receipt.print();

        // then
        assertThat(result).isEqualTo(expected);
    }
}
