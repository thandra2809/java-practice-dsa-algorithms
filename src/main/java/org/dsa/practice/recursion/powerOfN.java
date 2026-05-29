package org.dsa.practice.recursion;

public class powerOfN {
    static void main() {
        System.out.println(powerOfMtoN(2,4));

    }

    private static int powerOfMtoN(int m, int n) {
        if(n==0) {
            return 1;
        }else{
            return powerOfMtoN(m,n-1)*m;
        }
    }
}
