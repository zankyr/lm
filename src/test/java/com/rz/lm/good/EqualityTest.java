package com.rz.lm.good;

import com.rz.lm.Good;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EqualityTest {

    @Test
    void whenSameNameAndSamePrice_equalsShouldReturnTrue() {
        assertTrue(Good.taxed("good", new BigDecimal(1)).equals(Good.taxed("good", new BigDecimal(1))));
    }

    @Test
    void whenDifferentNames_equalsShouldReturnFalse() {
        assertFalse(Good.taxed("good", new BigDecimal(1)).equals(Good.taxed("another good", new BigDecimal(1))));
    }

    @Test
    void whenDifferentPrices_equalstShouldReturnFalse() {
        assertFalse(Good.taxed("good", new BigDecimal(1)).equals(Good.taxed("good", new BigDecimal(12))));
    }


}
