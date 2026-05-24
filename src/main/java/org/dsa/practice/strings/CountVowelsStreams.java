package org.dsa.practice.strings;

import java.util.Map;
import java.util.stream.Collectors;

public class CountVowelsStreams {
    static void main() {
        String testString = "How Are You";

        Map<Character, Long> vowelCount = testString.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .filter(c -> "aeiou".indexOf(c) >= 0)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(vowelCount);
    }
}
