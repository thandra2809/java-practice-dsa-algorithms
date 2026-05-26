package org.namastedev.arrays;

public class NumberPalindrome {
    static void main() {

        int number = 121;
        int remainder = 0;
        int reverse = 0;
        int absNumber = 0;
        boolean isAbsapplied = false;

        if (number < 0) {
            isAbsapplied = true;
             absNumber = Math.abs(number);
        }else{
            absNumber = number;
        }

        while (absNumber > 0) {

            // get the last digit
            remainder  = absNumber % 10;

            // start appending other way by multiplying 10
            reverse = reverse * 10 + remainder;

            // reduce the last digit of the number
            absNumber = absNumber / 10;
        }

        if(isAbsapplied){
            reverse = reverse * -1;
        }

        System.out.println(reverse);

//        char[] array = String.valueOf(reverse).toCharArray();
//
//        int i=0;
//        int j=array.length-1;
//
//        boolean isPalindrome = true;
//
//        while(i<j){
//            if(array[i]!=array[j]){
//                isPalindrome =  false;
//                break;
//            }
//
//            i++;
//            j--;
//        }
//
//        System.out.println("******************");
//        System.out.println(isPalindrome);
//        System.out.println("******************");

    }
}
