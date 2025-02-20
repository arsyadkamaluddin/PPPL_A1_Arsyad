package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LargestTest {
    Integer[] numbers = {7,8,9};
    int max = Largest.largest(numbers);

    @Test
    void largest() {
        Assertions.assertEquals(9, max);
    }
}