package org.dsa.practice.recursion;

public class GlobalVariableRecursion {
    static int x = 0;

    public static void main(String[] args) {
        int result = 0;

        result = function(5);

        System.out.println(result);
    }

    static int function(int n){

        if(n>0){
            x++;
            return function(n-1)+x;
        }
        return 0;
    }
}