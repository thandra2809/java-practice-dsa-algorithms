package org.namastedev.strings;

public class ReverseVowelsOfString {

    static void main() {
        String s = "IceCreAm";


        String reversedString = reverseJustVowels(s);
        System.out.println();
        System.out.println(reversedString);

    }

    private static String reverseJustVowels(String s) {

        char[] charArray = s.toCharArray();

        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {

            if (!isVowel(charArray[left])) {
                left++;
                continue;
            }
            if (!isVowel(charArray[right])) {
                right--;
                continue;
            }

            if (isVowel(charArray[left]) && isVowel(charArray[right])) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }


        }

        return String.valueOf(charArray);
    }

    public static boolean isVowel(char c) {
        return switch (Character.toLowerCase(c)) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }

}
