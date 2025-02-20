package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LargestTest {
    Integer[] numbers = {1, 2, 3};
    int max = Largest.largest(numbers);

    @Test
    void largest() {
        Assertions.assertEquals(3, max);
    }
}