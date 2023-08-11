package com.telrun.rledenev.summary_0811;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

class MyNumberListTest {
    private MyNumberList myNumberList;
    private static final Integer CAPACITY = 10;

    @BeforeEach
    void setUp() {
        myNumberList = new MyNumberList(CAPACITY);
        myNumberList.add(1L);
        myNumberList.add(2L);
        myNumberList.add(3L);
        myNumberList.add(4L);
        myNumberList.add(5L);
    }

    @AfterEach
    void tearDown() {
        myNumberList = null;
    }

    @Test
    void addNumberInBoundTest() {
        myNumberList.add(6L);
        long size = myNumberList.size();
        Assertions.assertEquals(6, size);
    }

    @Test
    void addNumberOutOfBoundTest() {
        myNumberList.add(6L);
        myNumberList.add(7L);
        myNumberList.add(8L);
        myNumberList.add(9L);
        myNumberList.add(10L);
        myNumberList.add(11L);
        Assertions.assertEquals(10, myNumberList.size());
    }

    @Test
    void removePositiveCaseTest() {
        myNumberList.remove(3);
        Assertions.assertEquals(4, myNumberList.size());
    }

    @Test
    void removeSizeEqualsTest() {
        myNumberList.remove(3);
        Assertions.assertEquals(4, myNumberList.size());
    }

    @Test
    void removeNegativeCaseSubZeroTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> myNumberList.remove(-1));
    }

    @Test
    void removeNegativeCaseAboveSizeTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> myNumberList.remove(7));
    }

    @Test
    void removeReturnNumberTest() {
        Assertions.assertEquals(4L, myNumberList.remove(3));
    }

    @Test
    void sum() {
        Assertions.assertEquals(15L, myNumberList.sum());
    }

    @Test
    void size() {
        Assertions.assertEquals(5, myNumberList.size());
    }
}