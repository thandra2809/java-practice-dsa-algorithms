package org.dsa.practice.strings;

public class ConsonantCountOnly {

    static void main() {

        String str = "This Is getting Crazy we only need to count Consonants";

        char[] charArray = str.toCharArray();
        int consonantCount = 0;
        int totalCharCount = 0;

        for (int i = 0; i < charArray.length; i++) {

            if((charArray[i] >='a' && charArray[i] <= 'z')||(charArray[i] >='A' && charArray[i] <= 'Z')) {
                totalCharCount++;
            }

            if((charArray[i] >='a' && charArray[i] <= 'z')&& !(charArray[i]=='a' || charArray[i] == 'e' || charArray[i] == 'i' || charArray[i] == 'o' || charArray[i] == 'u')) {
                consonantCount++;
            }

            if((charArray[i] >='A' && charArray[i] <= 'Z')&& !(charArray[i]=='A' || charArray[i] == 'E' || charArray[i] == 'I' || charArray[i] == 'O' || charArray[i] == 'U')) {
                consonantCount++;
            }

        }

        System.out.println(consonantCount);
        System.out.println(totalCharCount);
        System.out.println("Vowels Count::" + (totalCharCount-consonantCount));


    }
}
