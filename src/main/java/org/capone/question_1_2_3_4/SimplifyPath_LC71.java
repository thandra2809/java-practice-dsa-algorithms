package org.capone.question_1_2_3_4;

import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath_LC71 {
    static void main() {
        String path = "/home/user/Documents/../Pictures";
        System.out.println(simplifyPath(path));

    }

    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] directories = path.split("/");
        for (String dir : directories) {
            if (dir.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!dir.isEmpty() && !dir.equals(".")) {
                stack.push(dir);
            }
        }
        return "/" + String.join("/", stack);
    }
}
