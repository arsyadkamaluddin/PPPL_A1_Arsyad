package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCollectionTest {
    ScoreCollection score = new ScoreCollection();
    @Test
    void averageScore() {
        score.addScore(10);
        score.addScore(20);
        score.addScore(30);

        Assertions.assertEquals(20,score.averageScore());
    }
}