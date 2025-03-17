package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void isEven(int number){
        Calculator calc = new Calculator(0, 0);
        assertTrue(calc.isEven(number), "IsEven Failed");
    }
    @ParameterizedTest
    @CsvSource({"10, 25, 35", "12, 13, 25", "43, 54, 97"})
    void add(int a, int b, int expected) {
        Calculator calc = new Calculator(a, b);
        assertEquals(expected, calc.add(), "Addition Failed");
    }
    @ParameterizedTest
    @MethodSource("substractData")
    void substract(int a, int b, int expected) {
        Calculator calc = new Calculator(a, b);
        assertEquals(expected, calc.substract(), "Substraction Failed");
    }

    @ParameterizedTest
    @MethodSource("multipleData")
    void multiple(int a, int b, int expected) {
        Calculator calc = new Calculator(a, b);
        assertEquals(expected, calc.multiple(), "Multipy Failed");
    }

    @ParameterizedTest
    @MethodSource("divideData")
    void divide(int a, int b, int expected) {
        Calculator calc = new Calculator(a, b);
        assertEquals(expected, calc.divide(), "Divide Failed");
    }

    static Stream<Arguments> substractData() {
        return Stream.of(
                Arguments.of(43, 10, 33),
                Arguments.of(30, 12, 18),
                Arguments.of(10, 20, -10)
        );
    }

    static Stream<Arguments> multipleData() {
        return Stream.of(
                Arguments.of(10, 10, 100),
                Arguments.of(6, 5, 30),
                Arguments.of(8, 7, 56)
        );
    }

    static Stream<Arguments> divideData() {
        return Stream.of(
                Arguments.of(100, 10, 10),
                Arguments.of(325, 25, 13),
                Arguments.of(50, 10, 5)
        );
    }
}