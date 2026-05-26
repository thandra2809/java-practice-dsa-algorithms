package org.namastedev.arrays;

public class ReverseASignedInteger {
    public static void main(String[] args) {


        int x=-1534236469;

        // copy the number in to another number
        int xCopy = x;

        int reversed = 0;
        int lastDigit = 0;

        // do the absolute of number
        x= Math.abs(x);

        while (x>0) {
            lastDigit  = x % 10;

            if (reversed > Integer.MAX_VALUE / 10 ||
                    (reversed == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                reversed = 0;
                break;
            }
            reversed = reversed *10 + lastDigit;
            x=x/10;
        }

        if(xCopy<0){
            reversed = reversed*-1;
        }

        System.out.println(reversed);
    }
}
