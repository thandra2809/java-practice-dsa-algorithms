package org.dsa.practice.stackproblems;

import java.util.Stack;

public class RemoveOuterParenthesis {
    static void main() {
//        String str1 = "(()())(())";
//        String str2 = "(()())(())(()(()))";
//        String str3 = "()()";
        String str4 = "(";
        String str5 = ")";

//        System.out.println(removeOuterParentheses(str1));
//        System.out.println(removeOuterParentheses(str2));
//        System.out.println(removeOuterParentheses(str3));
        System.out.println(removeOuterParentheses(str4));
        System.out.println(removeOuterParentheses(str5));


    }

    public static String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();


        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (!stack.isEmpty()) {
                    sb.append(c);
                }

                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    sb.append(c);
                }
                stack.pop();
            }

        }

        return sb.toString();
    }
}
