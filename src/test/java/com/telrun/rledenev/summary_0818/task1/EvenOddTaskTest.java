package com.telrun.rledenev.summary_0818.task1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EvenOddTaskTest {
    private static final List<Integer> NUMBERS = Arrays.asList(1, null, 2, 3, 4, null, 5, 6, 7, null, 8, 9, 10);

    @Test
    void getEvenOddListPositiveTest() {
        List<Integer> expectedEven = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> expectedOdd = Arrays.asList(1, 3, 5, 7, 9);

        EvenAndOddLists expected = new EvenAndOddLists(expectedEven, expectedOdd);
        assertEquals(expected, EvenOddTask.getEvenOddList(NUMBERS));
    }

    @Test
    void getEvenOddListNullCaseTest() {
        assertThrows(IllegalArgumentException.class, () -> EvenOddTask.getEvenOddList(null));
    }
}