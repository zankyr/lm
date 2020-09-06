package com.rz.lm.basket;

import com.rz.lm.Basket;
import com.rz.lm.Good;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalTest {

    //TODO centralize objects creation logics

    @Test
    void whenAddGood_thenTotalShouldBeCorrect() {
        // given
        Basket basket = new Basket();
        Good given = Good.taxFree("good name", BigDecimal.valueOf(1.00));

        // when
        basket.addGood(given);

        // then
        assertThat(basket.getTotal()).isEqualTo(new BigDecimal("1.00"));
    }

    @Test
    void whenMultipleAddGood_thenTotalShouldBeCorrect() {
        // given
        Basket basket = new Basket();
        Good given = Good.taxFree("good name", BigDecimal.valueOf(1.00));

        // when
        basket.addGood(given);
        basket.addGood(given);

        // then
        assertThat(basket.getTotal()).isEqualTo(new BigDecimal("2.00"));
    }
}
