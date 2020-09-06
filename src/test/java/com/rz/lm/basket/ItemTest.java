package com.rz.lm.basket;

import com.rz.lm.Basket;
import com.rz.lm.Good;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {

    //TODO centralize objects creation logics

    @Test
    public void whenAddGood_thenBasketShouldContainsTheItem() {
        // given
        Basket basket = new Basket();
        Good given = Good.taxFree("good name", BigDecimal.valueOf(1.00));

        // when
        basket.addGood(given);

        // then
        assertThat(basket.getGoods()).containsKey(given);
    }

    @Test(expected = Exception.class)
    public void whenAddNullItem_thenException() {
        // given
        Basket basket = new Basket();

        // when
        basket.addGood(null);

    }
}
