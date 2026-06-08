package org.capone.question_1_2_3_4;

import java.util.Stack;

public class ValidParanthesis {
    static void main() {

        String s1 = "()";
        System.out.println(isValid(s1));
        System.out.println("*******************");

        String s2 = "()[]{}";
        System.out.println(isValid(s2));
        System.out.println("*******************");

        String s3 = "([)]";
        System.out.println(isValid(s3));
        System.out.println("*******************");

    }

    public static boolean isValid(String s) {

        if(s!=null&&s.length()<=1) return false;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            switch (c) {
                case '(', '{', '[':
                    stack.push(c);
                    break;
                case ')':
                    if (!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                    break;
                case '}':
                    if (!stack.empty() && stack.peek() == '{') {
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                    break;
                case ']':
                    if (!stack.empty() && stack.peek() == '[') {
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                    break;
                default:
                    break;
            }

        }

        return stack.isEmpty();

    }
}
