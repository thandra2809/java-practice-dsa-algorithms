package org.dsa.practice.recursion;

public class Fibonacci {
    static void main() {

        int n = 10;
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    private static int fibonacci(int n) {
        if(n<=1){
            return n;
        }else{
            return fibonacci(n-2) + fibonacci(n-1);
        }
    }
}
