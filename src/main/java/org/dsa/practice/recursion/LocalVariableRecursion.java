package org.dsa.practice.recursion;

public class LocalVariableRecursion {

    public static void main(String[] args) {
        int result = 0;

        result = function(5);

        System.out.println(result);
    }

    static int function(int n){

        if(n>0){
            // n++; // this will get in to infinite loop and never return :-)
            return function(n-1)+n;
        }
        return 0;
    }
}