package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student = new Student("Arsyad",8,true);

    @Test
    void isDoingMBKM() {
        Assertions.assertEquals(true,student.isDoingMBKM());
    }

    @Test
    void getName() {
        Assertions.assertEquals("Arsyad",student.getName());
    }

    @Test
    void getSemester() {
        Assertions.assertEquals(8,student.getSemester());
    }

    @Test
    void isActive() {
        Assertions.assertEquals(true,student.isActive());
    }
}