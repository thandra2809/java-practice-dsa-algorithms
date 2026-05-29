package org.namastedev.strings;

public class Palindrome125 {
    static void main() {
        String str = "b";
        char[] characters = str.toLowerCase().toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < characters.length; i++) {
            if ((characters[i] > 96 && characters[i] < 123) || (characters[i] >= 48 && characters[i] <= 57)) {
                sb.append(characters[i]);
            }
        }

        System.out.println(sb);
        characters = sb.toString().toCharArray();


        int i = 0;
        int j = characters.length - 1;
        boolean isPalindrome = true;

        while (i < j) {
            if (characters[i] == characters[j]) {
                i++;
                j--;
            } else {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome);


    }
}
