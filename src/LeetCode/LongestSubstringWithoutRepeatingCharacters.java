package LeetCode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(lengthOfLongestSubstring(s.nextLine()));
    }

    private static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> uniqueCharacters = new HashSet<>();
        int maxCount = 0;
        int fromIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!uniqueCharacters.contains(chars[i])) {
                uniqueCharacters.add(chars[i]);
            } else {
                if (uniqueCharacters.size() > maxCount) {
                    maxCount = uniqueCharacters.size();
                }
                uniqueCharacters = new HashSet<>();
                i = s.indexOf(chars[i], fromIndex);
                fromIndex = i;
            }
        }
        if (uniqueCharacters.size() > maxCount) {
            maxCount = uniqueCharacters.size();
        }
        return maxCount;
    }
}
