package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator(20,10);

    @Test
    void aValue() {
        Assertions.assertEquals(20,calculator.a);
    }

    @Test
    void bValue() {
        Assertions.assertEquals(10,calculator.b);
    }

    @Test
    void add() {
        Assertions.assertEquals(30,calculator.add());
    }

    @Test
    void substract() {
        Assertions.assertEquals(10,calculator.substract());
    }

    @Test
    void multiple() {
        Assertions.assertEquals(200,calculator.multiple());
    }

    @Test
    void divide() {
        Assertions.assertEquals(2,calculator.divide());
    }


}