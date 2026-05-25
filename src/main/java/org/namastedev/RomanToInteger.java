package org.namastedev;

import java.util.HashMap;

public class RomanToInteger {
    static void main() {
        String str = "XI";

        long convertedIntegerValue = convertRomanToInteger(str);
        System.out.println(convertedIntegerValue);
    }

    private static long convertRomanToInteger(String str) {
        long result = 0;

        HashMap<Character, Long> romanToIntegerMap = new HashMap<>();
        romanToIntegerMap.put('I', 1L);
        romanToIntegerMap.put('V', 5L);
        romanToIntegerMap.put('X', 10L);
        romanToIntegerMap.put('L', 50L);
        romanToIntegerMap.put('C', 100L);
        romanToIntegerMap.put('D', 500L);
        romanToIntegerMap.put('M', 1000L);

        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            long currentValue = romanToIntegerMap.get(charArray[i]);

            long nextValue = (i + 1< charArray.length)?romanToIntegerMap.get(charArray[(i + 1)]):0L;


            if (currentValue >= nextValue) {
                result= result + currentValue;
            }else{
                result= result - currentValue;
            }

        }
        return result;

    }
}
