package com.rz.lm.good;

import com.rz.lm.Good;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class NameTest {
    @Test
    public void whenGoodIsCreated_nameShouldBeInitialized() {
        Good good = Good.taxed("good", BigDecimal.valueOf(14.99));
        assertEquals("good", good.getName());
    }

}
