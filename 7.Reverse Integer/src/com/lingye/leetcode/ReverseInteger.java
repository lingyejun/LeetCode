package com.lingye.leetcode;

public class ReverseInteger {

    public int reverseIntByString(int inputInt){

        //负数标志
        boolean negativeFlg=false;
        //结果输出
        int outputInt;
        //将负数转化为绝对值
        if(inputInt<0){
            inputInt=Math.abs(inputInt);
            negativeFlg=true;
        }
        //去除掉末尾多余的0
        while(inputInt%10==0){
            inputInt=inputInt/10;
        }
        //将处理好的整数转化为String
        String inputStr=String.valueOf(inputInt);
        String reversedStr="";

        //利用String特性倒叙转换字符串
        for(int i=inputStr.length()-1;i>=0;i--){
            reversedStr=reversedStr+inputStr.charAt(i);
        }
        //如果是负数则将
        if(negativeFlg){
            reversedStr="-"+reversedStr;
        }
        //将转换后的字符串转化为整数，异常为溢出情况
        try{
            outputInt=Integer.parseInt(reversedStr);
        }catch (NumberFormatException e){
            e.printStackTrace();
            //转化溢出则返回0
            outputInt=0;
        }
        return outputInt;
    }

    /**
     * 取模法计算倒序结果
     * 这个方法的精髓在于：给定一个数，进行循环对10取余，然后将余数在乘以10，加上下一次的计算结果，和Integer的最大值比较
     * 若是大于则溢出（所以我们应该用Long来保存返回数据防止溢出），返回0。
     * @param x
     * @return
     */
    public int reverse(int x) {

        long result = 0;
        int temp = Math.abs(x);
        while (temp > 0) {
            result *= 10;
            result += temp % 10;
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
            temp = temp / 10;
        }
        return (int) (x >= 0 ? result : -result);
    }
    public static void main(String[] args) {
        ReverseInteger r=new ReverseInteger();
        System.out.println(r.reverse(-323130000));

    }
}
