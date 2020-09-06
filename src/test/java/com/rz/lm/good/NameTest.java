package com.rz.lm.good;

import com.rz.lm.Good;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NameTest {
    @Test
    void whenGoodIsCreated_nameShouldBeInitialized() {
        Good good = Good.taxed("good", BigDecimal.valueOf(14.99));
        assertEquals("good", good.getName());
    }

}
