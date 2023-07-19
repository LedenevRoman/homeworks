package com.telrun.rledenev.LeetCode;

import java.util.*;

class Main {

    public static String SearchingChallenge(String str) {
        String[] words = str.replaceAll("[\\P{L}&&[^\\s']]", "")
                .toLowerCase()
                .trim()
                .split(" ");
        int currentLargestCount = 0;
        String currentBestWord = "";
        HashMap<Character, Integer> characterCount;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            characterCount = new HashMap<Character, Integer>();
            for (int j = 0; j < word.length(); j++) {
                Character character = word.charAt(j);
                if (characterCount.containsKey(character)) {
                    characterCount.put(character, characterCount.get(character) + 1);
                } else {
                    characterCount.put(character, 1);
                }
            }

            Iterator<Integer> iterator = characterCount.values().iterator();
            int thisCount = 0;
            while (iterator.hasNext()) {
                int thisCharacterCount = iterator.next();
                if (thisCount < thisCharacterCount) {
                    thisCount = thisCharacterCount;
                }
            }
            if (thisCount > currentLargestCount) {
                currentLargestCount = thisCount;
                currentBestWord = word;
            }
        }
        if (currentLargestCount == 1) {
            return "-1";
        } else {
            return currentBestWord.replaceAll("[cxm9uioad43e]", "");
        }
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(SearchingChallenge(s.nextLine()));
    }
}