package com.lingye.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * @Author: LeeChao
 * @Date: 2018/10/28
 * @Describe:
 * @Modified By:
 */
public class GenerateParentheses {

    /**
     * 解题核心：正确的字符串为左括号的个数=右括号的个数，且左括号要在左边，右括号要在右边.
     * 如：n=3,一共6个括号，在生成正确串的过程中，如果到第五个是左括号个数小于右括号个数，那么这肯定不是一个正确串。
     * 定义x为左括号的个数，y为右括号的个数(x,y)，起点为(0,0),终点为(n,n)，在移动的过程中(x+1,y)、(x,y+1)--如果先移动右括号则一开始就错了。
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> parenthesisList = new ArrayList<>();
        generateStringPath(n, 0, 0, "", parenthesisList);
        return parenthesisList;
    }

    /**
     * 递归走完全图路径
     *
     * @param n
     * @param x
     * @param y
     * @param curStr
     * @param trueParent
     */
    public void generateStringPath(int n, int x, int y, String curStr, List<String> trueParent) {
        // 递归结束条件，因为左括号x==n时，还没有生成一个完整的串
        if(y==n){
            trueParent.add(curStr);
        }
        // 一定要先走x（左括号），不然一开始就错了，x==n时就不需要在走x，左括号了，再走就是x>n错误字符串。
        if (x < n) {
            generateStringPath(n, x + 1, y, curStr + "(", trueParent);
        }
        // 走完x+1，再走y+1,只有到最后才能x==y，在行进的过程中如果x==y，加右括号的话，会出现右括号多于左括号的错误情况
        if (x > y) {
            generateStringPath(n, x, y + 1, curStr + ")", trueParent);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        List<String> list = gp.generateParenthesis(3);
    }
}
