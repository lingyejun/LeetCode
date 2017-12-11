package com.lingye.leetcode;

import java.math.BigDecimal;

public class StringToInteger {

    /**
     * atoi:ascii to integer
     * 跳过前面的空白字符（例如空格，tab缩进）直到遇上数字或正负符号才开始做转换
     * 遇到字母或者空格停止
     * @param str
     * @return
     */
    public int myAtoi(String str){

        // 设定返回结果默认是0，且类型为long,便于后续同最大、值最小值判断
        long result=0;
        // 将正负号和数字筛选到一个新的字符串中
        String newStr="";
        // 用来存储正负号
        char plusMinus=' ';
        // 正负号出现的次数
        int plusMinusNum=0;
        // 记录符号出现的位置
        int plusMinusIndex=0;

        // 输入字符串为null或者空串则直接返回
        if(str==null || str.equals("")){
            return (int)result;
        }
        // 遍历字符串，筛选出真正的数字
        for(int i=0;i<str.length();i++){
            if(i!=0 && newStr.equals("") && str.charAt(i-1)!=' ' && str.charAt(i) ==' '){
                return 0;
            }else if(newStr.equals("") && str.charAt(i)==' '){ // 将字符串开头的空格去掉
                continue;
            }else if(Character.isLetter(str.charAt(i)) || (!newStr.equals("")&&str.charAt(i)==' ')){
                // 新的数字串不为空但后面出现空格如23a4返回23
                break;
            }else if(str.charAt(i)=='+' || str.charAt(i)=='-'){
                // 出现多个加号则返回0
                plusMinus=str.charAt(i);
                plusMinusNum++;
                plusMinusIndex=i;
            }else{
                newStr+=str.charAt(i);
            }
        }
        boolean isDigit=true;
        if(!newStr.equals("")&&plusMinusNum<=1){
        for(int j=0;j<newStr.length();j++){
            if(!Character.isDigit(newStr.charAt(j))){
                isDigit=false;
                return (int)result;
            }
        }
        }else {
            return 0;
        }
        // Integer的最大和最小值需要处理,超出限制会报异常，直接返回0
        try{
            plusMinus=(plusMinus==' ')?'+':plusMinus;
            //result=Long.parseLong(plusMinus+newStr);
            // 用BigDecimal承接超级大的数
            BigDecimal res=new BigDecimal(plusMinus+newStr);
            BigDecimal border=BigDecimal.valueOf(Integer.MAX_VALUE);
            // 如果比最大值大，则返回最大值
/*            if(res>Integer.MAX_VALUE){
                result=2147483647;
            }else if(result<Integer.MIN_VALUE){
                // 如果比最小值小，则返回最小值
                result=-2147483648;
            }*/
            // -1 小于,0 等于,1 大于
            if(res.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE))==1){
                result=2147483647;
            }else if(res.compareTo(BigDecimal.valueOf(Integer.MIN_VALUE))==-1){
                // 如果比最小值小，则返回最小值
                result=-2147483648;
            }else {
                result=Integer.parseInt(plusMinus+newStr);
            }
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }

        return (int)result;
    }

    public static void main(String[] args) {

        StringToInteger st=new StringToInteger();
        int a=st.myAtoi("1");
        System.out.println(a);
    }
}
