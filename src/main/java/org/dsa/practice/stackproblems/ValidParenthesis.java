package org.dsa.practice.stackproblems;

import java.util.Stack;

public class ValidParenthesis {

    static void main() {
        String parenthesisString1 = "()";
        String parenthesisString2 = "()[]{}";
        String parenthesisString3 = "(]";
        String parenthesisString4 = "([])";
        String parenthesisString5 = "([)]";

        System.out.println(isValidParenthesis(parenthesisString1));
        System.out.println(isValidParenthesis(parenthesisString2));
        System.out.println(isValidParenthesis(parenthesisString3));
        System.out.println(isValidParenthesis(parenthesisString4));
        System.out.println(isValidParenthesis(parenthesisString5));


    }

    static boolean isValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            switch (c){
                case '(', '{','[':
                    stack.push(c);
                    break;
                case ')':
                    if (!stack.empty()&&stack.peek()=='(')  {stack.pop();}
                    break;
                case '}':
                    if (!stack.empty()&&stack.peek()=='{')  {stack.pop();}
                    break;
                case ']':
                    if (!stack.empty()&&stack.peek()=='[')  {stack.pop();}
                    break;
                default:
                    break;
            }

        }

        return stack.isEmpty();
    }

}
