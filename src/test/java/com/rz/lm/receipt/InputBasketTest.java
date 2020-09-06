package com.rz.lm.receipt;

import com.rz.lm.Receipt;
import org.junit.Test;

public class InputBasketTest {
    @Test(expected = Exception.class)
    public void whenBasketIsNull_thenThrowException() {
        // when
        new Receipt(null).print();
    }


}
