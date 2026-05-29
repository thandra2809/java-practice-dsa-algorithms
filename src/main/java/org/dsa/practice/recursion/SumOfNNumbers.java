package org.dsa.practice.recursion;

public class SumOfNNumbers {
    static void main() {

        System.out.println(sumOfNNumbers(3));

    }

    static int sumOfNNumbers(int n) {
        if (n == 0) {
            return 0;
        } else {
            return sumOfNNumbers(n - 1) + n;
        }
    }

}
