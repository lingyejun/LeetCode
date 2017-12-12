package com.lingye.leetcode;

/**
 * @Author: LeeChao
 * @Date: 2017/12/12
 * @Describe:
 * @Modified By:
 */
public class PalindromeNumber {

    /**
     * 判断一个数字是不是回文
     * 利用它的特性回文之后同回文之前是一样的
     * 即将一个数字Reverse之后判断同之前是否相等
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x){
        boolean isPalindrome=false;

        //将x倒序,因为只是判断一个数是不是回文，不需要管是否大于最大值
        long reverseInt=0;
        long temp=Math.abs(x);
        while(temp>0){
            reverseInt*=10;
            reverseInt+=temp%10;
            // 因为输入是int值，若倒序之后大于最大值，则肯定不是回文
            temp/=10;
        }
        if(x==reverseInt){
            isPalindrome=true;
        }
        return isPalindrome;
    }

    /**
     * 将整数转化为字符串然后判断i和length-1-i是否相等
     * 负数肯定不是回文数
     * @param x
     * @return
     */
    public boolean isPalindromeByStr(int x){
        //筛选掉负号
        int absx = Math.abs(x);
        //将x转化为字符串
        String str = String.valueOf(absx);
        //每次匹配的结果
        boolean perMatch = true;
        if (str.length() == 1) {
            return perMatch;
        }
        //遍历字符串,只遍历一半即可
        for (int i = 0; i < str.length() / 2; i++) {
            //数组长度除以2后则需要两两配对全部一致
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                perMatch = false;
                break;
            }
        }
        return perMatch;
    }
    public static void main(String[] args) {
        PalindromeNumber p=new PalindromeNumber();
        boolean a=p.isPalindromeByStr(-2147447412);
        boolean b=p.isPalindrome(-2147447412);
        System.out.println(a);
    }
}
