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
        myNumberList.add(1);
        myNumberList.add(2);
        myNumberList.add(3);
        myNumberList.add(4);
        myNumberList.add(5);
    }

    @AfterEach
    void tearDown() {
        myNumberList = null;
    }

    @Test
    void addNumberInBoundTest() {
        myNumberList.add(6);
        Assertions.assertEquals(6, myNumberList.size());
        Assertions.assertEquals(21, myNumberList.sum());
    }

    @Test
    void addNumberOutOfBoundTest() {
        myNumberList.add(6);
        myNumberList.add(7);
        myNumberList.add(8);
        myNumberList.add(9);
        myNumberList.add(10);
        myNumberList.add(11);
        Assertions.assertEquals(10, myNumberList.size());
        Assertions.assertEquals(55, myNumberList.sum());
    }

    @Test
    void removePositiveCaseTest() {
        int actual = myNumberList.remove(3);
        Assertions.assertEquals(4, actual);
        Assertions.assertEquals(4, myNumberList.size());
        Assertions.assertEquals(11, myNumberList.sum());
    }

    @Test
    void removeFromFullArrayTest() {
        myNumberList.add(6);
        myNumberList.add(7);
        myNumberList.add(8);
        myNumberList.add(9);
        myNumberList.add(10);
        myNumberList.remove(4);
        Assertions.assertEquals(9, myNumberList.size());
        Assertions.assertEquals(50, myNumberList.sum());
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
    void sum() {
        Assertions.assertEquals(15, myNumberList.sum());
    }

    @Test
    void size() {
        Assertions.assertEquals(5, myNumberList.size());
    }
}