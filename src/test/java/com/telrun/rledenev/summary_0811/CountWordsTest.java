package com.telrun.rledenev.summary_0811;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountWordsTest {
    private final CountWords countWords = new CountWords();
    private final String sentence = "I love Java... although Java is quite hard to learn!";

    @Test
    void countJavaWordTest() {
        Assertions.assertEquals(2, countWords.countWords(sentence).get("Java"));
    }

    @Test
    void countWordsTest1() {
        Assertions.assertEquals(1, countWords.countWords(sentence).get("learn"));
    }

    @Test
    void emptyStringTest() {
        Assertions.assertNull(countWords.countWords("").get("abc"));
    }

    @Test
    void nullStringTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> countWords.countWords(null));
    }

    @Test
    void multipleSpacesTest() {
        Assertions.assertNull(countWords.countWords("a  b").get(""));
    }

    @Test
    void punctuationAbsenceTest() {
        Assertions.assertEquals(1, countWords.countWords(sentence).get("learn"));
    }

}