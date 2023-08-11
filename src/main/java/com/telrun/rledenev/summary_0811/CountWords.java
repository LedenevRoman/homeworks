package com.telrun.rledenev.summary_0811;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CountWords {

    public Map<String, Integer> countWords(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(sentence.split("[\\s\\p{Punct}]+"))
                .collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));
    }
}
