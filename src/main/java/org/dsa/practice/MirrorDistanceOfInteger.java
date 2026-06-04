package org.dsa.practice;

public class MirrorDistanceOfInteger {
    static void main() {
        System.out.println(mirrorDistance(123));
    }

    public static int mirrorDistance(int n) {
        int reversedDigit = 0;
        int actualValue = n;
        // reverse integer
        while (n > 0) {
            int lastDigit = n % 10;
            reversedDigit = reversedDigit * 10 + lastDigit;
            n = n / 10;
        }

        return Math.abs(actualValue - reversedDigit);
    }
}
