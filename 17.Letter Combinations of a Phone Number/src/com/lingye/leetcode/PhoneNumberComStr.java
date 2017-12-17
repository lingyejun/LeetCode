package com.lingye.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: LeeChao
 * @Date: 2017/12/17
 * @Describe:
 * @Modified By:
 */
public class PhoneNumberComStr {

    public List<String> letterCombinations(String digits){

        String letter0="0";
        String letter1="1";
        String letter2="abc";
        String letter3="def";
        String letter4="ghi";
        String letter5="jkl";
        String letter6="mno";
        String letter7="pqrs";
        String letter8="tuv";
        String letter9="wxyz";

        // 每输入一个数字就直接去寻找phoneLetter[num]即可
        String[] phoneLetter={letter0,letter1,letter2,letter3,letter4,letter5,letter6,letter7,letter8,letter9};

        // 初始化返回结果
        List<String> result=new ArrayList<>();
        if (digits.equals("")){
            return result;
        }
        result.add("");
        // 一共输入几个数字
        for(int i=0;i<digits.length();i++){
            // 当前位置的数字对应的字符串
            String nChars=phoneLetter[Character.getNumericValue(digits.charAt(i))];
            List<String> temp=new ArrayList<>();
            for (int c=0;c<nChars.length();c++){
                for (int r=0;r<result.size();r++) {
                    temp.add(result.get(r) + nChars.charAt(c));
                }
            }
            result=temp;

        }
        return result;
    }

    public static void main(String[] args) {
        PhoneNumberComStr phoneNumberComStr=new PhoneNumberComStr();
        List<String> a=phoneNumberComStr.letterCombinations("23");
    }
}
