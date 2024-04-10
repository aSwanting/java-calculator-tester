package org.learning.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void add() {
        assertEquals(5, 2 + 3);
    }

    @Test
    void subtract() {
        assertEquals(3, 8 - 5);
    }

    @Test
    void divide() {
        assertEquals(3, 9 / 3);
    }

    @Test
    void multiply() {
        assertEquals(27, 9 * 3);
    }
}