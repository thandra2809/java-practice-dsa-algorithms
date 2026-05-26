package org.namastedev.strings;

import java.util.*;

public class MostFrequentVowelConsonant3541 {

    static void main() {

        String s= "successes";
        HashMap<Character, Integer> countOfCharacters = new HashMap<Character, Integer>();

        char[] words = s.toCharArray();

        for (char c : words) {
            countOfCharacters.put(c, countOfCharacters.getOrDefault(c, 0) + 1);
        }

        Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u');
        int maxVowelCount =0 ;
        int maxConsonantCount =0 ;

        for(int j=0;j<words.length;j++){

            if(vowelSet.contains(words[j])){
                if(countOfCharacters.getOrDefault(words[j], 0)>maxVowelCount) {
                    maxVowelCount = countOfCharacters.getOrDefault(words[j], 0);
                }
            }else{
                if(countOfCharacters.getOrDefault(words[j], 0)>maxConsonantCount) {
                    maxConsonantCount = countOfCharacters.getOrDefault(words[j], 0);
                }
            }

        }

        System.out.println(maxVowelCount);
        System.out.println(maxConsonantCount);

        System.out.println(maxVowelCount+maxConsonantCount);

    }
}
