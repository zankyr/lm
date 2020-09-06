package com.rz.lm.basket;

import com.rz.lm.Basket;
import com.rz.lm.Good;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemCountTest {

    //TODO centralize objects creation logics

    @Test
    void whenAddGood_ifItemIsNotPresent_thenCountShouldBeOne() {
        // given
        Basket basket = new Basket();
        Good given = Good.taxFree("good name", BigDecimal.valueOf(1.00));

        // when
        basket.addGood(given);

        // then
        assertThat(basket.getGoods().get(given).equals(1));
    }

    @Test
    void whenAddGood_ifItemIsPresent_thenCountShouldBeTwo() {
        // given
        Basket basket = new Basket();
        Good given = Good.taxFree("good name", BigDecimal.valueOf(1.00));

        // when
        basket.addGood(given);
        basket.addGood(given);

        // then
        assertThat(basket.getGoods().get(given)).isEqualTo(2);
    }
}
