package com.lingye.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: LeeChao
 * @Date: 2018/10/24
 * @Describe:
 * @Modified By:
 */
public class ValidParentheses {

    /**
     * 判断两个字符是否匹配
     *
     * @param char1
     * @param char2
     * @return
     */
    public static boolean matchTwoChar(char char1, char char2) {
        if (char1 == '(' && char2 == ')') {
            return true;
        } else if (char1 == '[' && char2 == ']') {
            return true;
        } else if (char1 == '{' && char2 == '}') {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断一个字符串是否满足ValidParentheses
     *
     * @param str
     * @return
     */
    public static boolean isValidParentheses(String str) {
        boolean validFlg = true;
        if (str == null || str.length() % 2 != 0) {
            return !validFlg;
        } else {
            if (str.equals("")) {
                return validFlg;
            }
            char[] array = str.toCharArray();
            Stack<Character> stack = new Stack();
            for (int i = 0; i < array.length; i++) {
                if (stack.empty()) {
                    stack.push(array[i]);
                } else {
                    if (matchTwoChar(stack.peek().charValue(), array[i])) {
                        stack.pop();
                    } else {
                        stack.push(array[i]);
                    }
                }

            }
            if (!stack.empty()) {
                validFlg = false;
            }
        }
        return validFlg;

    }

    public static void main(String[] args) {
        String str = "{}[[]]()";
        System.out.println(isValidParentheses(str));
    }
}
