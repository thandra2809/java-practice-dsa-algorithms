package org.dsa.practice.strings;

public class IsPalindrome {

    static void main() {

        String str = "madam";

        boolean isPalindrome = checkIfPalindrome1(str);

        if (isPalindrome) {
            System.out.println("The supplied string " + str + " is palindrome");
        } else {
            System.out.println("The supplied string " + str + " is not palindrome");
        }

        String str2 = "python";

        boolean isPalindrome2 = checkIfPalindrome1(str2);

        if (isPalindrome2) {
            System.out.println("The supplied string " + str2 + " is palindrome");
        } else {
            System.out.println("The supplied string " + str2 + " is not palindrome");
        }

    }

    private static boolean checkIfPalindrome1(String str) {

        char[] charArray = str.toCharArray();
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
