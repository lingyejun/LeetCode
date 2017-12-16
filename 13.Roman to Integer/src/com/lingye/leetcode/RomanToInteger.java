package com.lingye.leetcode;

/**
 * @Author: LeeChao
 * @Date: 2017/12/16
 * @Describe:
 * @Modified By:
 */
public class RomanToInteger {

    /**
     * 罗马数转化为整数
     *
     * @param romanStr
     * @return
     */
    public int romanToInt(String romanStr){

        int romanNum= charToInt(romanStr.charAt(0));

        // 主要考虑前面数字比当前数字小的情况
        for(int i=1;i<romanStr.length();i++){
            int curr=charToInt(romanStr.charAt(i));
            int pre=charToInt(romanStr.charAt(i-1));
            if(curr>pre){
                // 属于CM IV这种类型 如MCM 1000+100+900=2000 实则为1900
                romanNum=romanNum+(curr-2*pre);//在前一次会多加一次pre所以要再减去一个pre
            } else {
                romanNum+=curr;
            }
        }

        return romanNum;

    }

    public int charToInt(char c) {
        int result;
        switch (c) {
            case 'M':
                result = 1000;
                break;
            case 'D':
                result = 500;
                break;
            case 'C':
                result = 100;
                break;
            case 'L':
                result = 50;
                break;
            case 'X':
                result = 10;
                break;
            case 'V':
                result = 5;
                break;
            case 'I':
                result = 1;
                break;
            default:
                result = 0;
        }
        return result;
    }
    public static void main(String[] args) {

        RomanToInteger romanToInteger=new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("MMMCM"));
    }
}
