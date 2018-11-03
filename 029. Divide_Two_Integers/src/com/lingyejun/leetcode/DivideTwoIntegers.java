package com.lingyejun.leetcode;

/**
 * 29. Divide Two Integers
 * <p>
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 *
 * @Author: LeeChao
 * @Date: 2018/11/2
 * @Describe:
 * @Modified By:
 */
public class DivideTwoIntegers {

    /**
     * 定义变量t等于除数，定义计数p，当t的两倍小于等于被除数时，进行如下循环，t扩大一倍，p扩大一倍，然后更新res和m
     * <p>
     * dividend = divisor * n + r
     * = divisor * (2^0+2^1+...+2^k) + r
     * = divisor<<0 + divisor<<1 + divisor<<k +r
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // 商值的正负标记,异或运算
        boolean sign = (dividend < 0) ^ (divisor < 0);
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        // 倍数
        int result = 0;
        // 判断是整除
        while (ldividend >= ldivisor) {
            long k = ldivisor;
            long l = 1;
            // 并没有更新k的值，判断dividend >= divisor * 2
            while (ldividend >= (k << 1)) {
                // 更新k=k*2
                k = k << 1;
                // 已经是l=l*2的倍数了
                l = l << 1;
            }
            // 循环之后的商
            result += l;
            // 得到余数
            ldividend -= k;
        }
        return sign ? -result : result;
    }

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 1;
        DivideTwoIntegers dti = new DivideTwoIntegers();
        int a = dti.divide(dividend, divisor);
        System.out.println(a);
    }
}
