package com.telrun.rledenev.dryKissYagni;

import java.util.stream.Collectors;


public class StringUtils {
    public static String toUpperCase(String input) {
        return input.chars()
                .mapToObj(codePoint -> Character.toString(Character.toUpperCase(codePoint)))
                .collect(Collectors.joining());
    }
}