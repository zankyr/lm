package com.rz.lm.receipt;

import com.rz.lm.Receipt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputBasketTest {
    @Test
    void whenBasketIsNull_thenThrowException() {
        assertThrows(Exception.class, () -> new Receipt(null).print());
    }


}
