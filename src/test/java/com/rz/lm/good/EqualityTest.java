package com.rz.lm.good;

import com.rz.lm.Good;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EqualityTest {

    @Test
    public void whenSameNameAndSamePrice_equalsShouldReturnTrue() {
        assertEquals(Good.taxed("good", new BigDecimal(1)), Good.taxed("good", new BigDecimal(1)));
    }

    @Test
    public void whenDifferentNames_equalsShouldReturnFalse() {
        assertNotEquals(Good.taxed("good", new BigDecimal(1)), Good.taxed("another good", new BigDecimal(1)));
    }

    @Test
    public void whenDifferentPrices_equalstShouldReturnFalse() {
        assertNotEquals(Good.taxed("good", new BigDecimal(1)), Good.taxed("good", new BigDecimal(12)));
    }


}
