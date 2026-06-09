package org.namastedev;

public class IntegerToRoman {

        public String intToRoman(int num) {

            // Step 1: list all values from largest to smallest
            int[]    values  = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] symbols = { "M","CM", "D", "CD", "C","XC","L","XL","X","IX","V","IV","I"};

            StringBuilder result = new StringBuilder();

            // Step 2: go through each value
            for (int i = 0; i < values.length; i++) {

                // Step 3: keep subtracting while num >= current value
                while (num >= values[i]) {
                    result.append(symbols[i]);   // add the symbol
                    num -= values[i];            // subtract the value
                }
            }

            return result.toString();
        }

        public static void main(String[] args) {
            IntegerToRoman sol = new IntegerToRoman();

            System.out.println(sol.intToRoman(3749));  // MMMDCCXLIX
            System.out.println(sol.intToRoman(58));    // LVIII
            System.out.println(sol.intToRoman(1994));  // MCMXCIV
            System.out.println(sol.intToRoman(4));     // IV
            System.out.println(sol.intToRoman(9));     // IX
            System.out.println(sol.intToRoman(400));   // CD
        }

}
