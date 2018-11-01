package com.lingye.leetcode;

/**
 * @Author: LeeChao
 * @Date: 2017/12/15
 * @Describe:
 * @Modified By:
 */
public class IntegerToRoman {

    /**
     * 罗马数字采用七个罗马字母作数字
     * Ⅰ（1）、V（5）、X（10）、L（50）、C（100）、D（500）、M（1000）
     * 3999：MMM DCD XC IX
     *
     * 思路：因为罗马数字不是1+1+1....一直加上去的
     * 它是由几个字符代表固定的数字按照一定的组合，去堆积出来的。
     * 所以我们按照他的规则去进行拼凑即可。
     *
     * @param num
     * @return
     */
    public String intToRoman(int num){

        /**
         * 1、相同的数字连写、所表示的数等于这些数字相加得到的数、如：Ⅲ=3；
         * 2、小的数字在大的数字的右边、所表示的数等于这些数字相加得到的数、 如：Ⅷ=8、Ⅻ=12；
         * 3、小的数字（限于 I、X 和 C）在大的数字的左边、所表示的数等于大数减小数得到的数、如：Ⅳ=4、Ⅸ=9；
         * 4、正常使用时、连写的数字重复不得超过三次；
         * 5、在一个数的上面画一条横线、表示这个数扩大 1000 倍。
         */

        // 该数字由下列一个或多个且每个的数量不大于3拼凑而成
        // 把积木数字列出来,即不重复的组合
        int[] romanInt = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanStr = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V","IV", "I"};
        // 贪心算法好像可以
        int leftIndex = 0;
        String romanNum = "";

        while (num!=0) {
            // 该数字介于1-3999之间，我们先判断它的大致范围如100以内，就肯定用不到d500和m1000两个变量了
            if (num >= romanInt[leftIndex]) {//说明其应该包含这个字母
                num-=romanInt[leftIndex];
                romanNum += romanStr[leftIndex];
            } else if (num < romanInt[leftIndex]) {
                leftIndex++;
            } else {
                romanNum = romanStr[leftIndex];
            }

        }

        return romanNum;
    }

    public static void main(String[] args) {

        IntegerToRoman integerToRoman=new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(1));
    }
}
