package com.lingye.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LeeChao
 * @Date: 2017/12/5
 * @Describe: LongestSubstring
 * @Modified By:
 */
public class LongestSubstring {

    /**
     * 思路：一次循环便要求出最长不重复子串的长度 如qpxrjxkltzyx
     * 在遍历字符串的时候，需要知道：
     * 1.当前字符是否在此之前已经出现过
     * 2.因为要计算不重复子串的长度，所以也应该知道该字符最后出现的最后位置，
     * 如果下次出现，则不重复子串的开始位置=最后出现+1
     * 而存储字符和位置的数据结构，Map是最合适的
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        //异常返回
        if (s == null || s.equals("")) {
            return 0;
        }

        //定义Map数据结构，用来存储[已遍历过]的字符，及其位置
        Map<Character, Integer> table = new HashMap<Character, Integer>();

        //不重复子串的开始下标
        int lowerBound = 0;
        //不重复子串的最大长度
        int maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            Integer lastLocation = table.get(currChar);
            // 如果已出现过当前字符,且
            if (lastLocation != null && lastLocation >= lowerBound) {
                //下一个不重复子串要是比上一个子串长怎么办呢？把上一次的长度记录下来
                //精华就在这里，有一组变量即起始位置+上次子串长度=子串的位置，要计算最长的子串，所以下次会和上次进行比较
                maxLength = Math.max(i - lowerBound, maxLength);
                lowerBound = lastLocation + 1;
            }
            table.put(currChar, i);
        }

        //如果最后的字符之前没有重复的，则在循环外再进行判断
        return Math.max(s.length() - lowerBound, maxLength);
    }

    public static void main(String[] args) {

        //String s="qpxrjxkltzyx";

        int a=lengthOfLongestSubstring("");

    }
}
