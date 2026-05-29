package org.namastedev.recursion;

public class SumOfFirstNNumbers {
    static void main() {
        System.out.println(printSumOfFirstNNumbers(5));
    }

    private static int printSumOfFirstNNumbers(int n) {
        if (n == 0)
            return 0;

    return printSumOfFirstNNumbers(n - 1) + n;
    }
}
