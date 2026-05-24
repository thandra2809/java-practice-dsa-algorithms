package org.dsa.practice.strings;

import java.util.Arrays;

public class DuplicatesInStringMixed {
    static void main() {
        String bigString = "These ARE my findings. which Are Really GREAT";

        char[] charArray = bigString.toCharArray();

        int[] smallCapArray = new int[26];
        int[] largeCapArray = new int[26];

        for (char c : charArray) {
            System.out.printf("%d \n", (int) c);

            if (c >= 'a' && c <= 'z') {
                smallCapArray[c - 'a']++;
            }
            if (c >= 'A' && c <= 'Z') {
                largeCapArray[c - 'A']++;
            }
        }

        System.out.println(Arrays.toString(smallCapArray));


        for (int i = 0; i < smallCapArray.length; i++) {
            if (smallCapArray[i] > 1) {
                System.out.printf("%c duplicated %d times\n", (char) (i + 97), smallCapArray[i]);
            } else if (smallCapArray[i] == 1) {
                System.out.printf("%c appeared %d time\n", (char) (i + 97), smallCapArray[i]);
            } else {
                System.out.printf("%c not present\n", (char) (i + 97));
            }

        }

        System.out.println(Arrays.toString(largeCapArray));

        for (int i = 0; i < largeCapArray.length; i++) {
            if (largeCapArray[i] > 1) {
                System.out.printf("%c duplicated %d times\n", (char) (i + 65), largeCapArray[i]);
            } else if (largeCapArray[i] == 1) {
                System.out.printf("%c appeared %d time\n", (char) (i + 65), largeCapArray[i]);
            } else {
                System.out.printf("%c not present\n", (char) (i + 65));
            }

        }

    }
}
