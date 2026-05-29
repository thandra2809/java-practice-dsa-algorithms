package org.dsa.practice.recursion;

public class FactorialOfN {
    static void main() {
        System.out.println(factorialOfN(5));
    }

    private static int factorialOfN(int n) {

        if(n==0) {
            return 1;
        }else{
            System.out.println("The value of N is:: "+n);
            return factorialOfN(n-1) * n;
        }
    }
}
