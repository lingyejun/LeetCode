package com.lingye.leetcode;

/**
 * @Author: LeeChao
 * @Date: 2017/12/12
 * @Describe:
 * @Modified By:
 */
public class LongestPalSub {

    /**
     * 从一个字符串中寻找最长的回文串，并返回.
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s){

        if(s==null || s.isEmpty()){
            return null;
        }
        if(s.length()==1){
            return s;
        }
        //设定循环是对比变量
        int maxPalLength=0;
        //设定回文串的初识值
        String maxPalStr=s.substring(0,1);
        for(int i=0;i<s.length()-1;i++){
            // 每一个节点都做中心扩展，求回文值
            String oddStr=searchPalindrome(s,i,i);
            if(oddStr.length()>maxPalLength){
                maxPalLength=oddStr.length();
                maxPalStr=oddStr;
            }
            // 因为不确定子串的最大回文串是奇数还是偶数，所以每次都求两次
            String evenStr=searchPalindrome(s,i,i+1);
            if(evenStr.length()>maxPalStr.length()){
                maxPalLength=evenStr.length();
                maxPalStr=evenStr;
            }

        }
        return maxPalStr;
    }

    /**
     * 中心节点判断法：
     * 奇数长度的字符串，我们选取一个中间值然后从两边扩展，查找最大字符串
     * 偶数长度的字符串，abba，如果按照上面的方式，这就不是一个回文，但是它是，我们要选取两个节点从他们两边扩展
     *
     * @param s
     * @return
     */
    public String searchPalindrome(String s,int start,int end){

        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            //满足条件后各自向两边扩展
            start--;
            end++;
        }
        // 满足条件后start已经--了，所以截取的时候start应该+1
        String palStr=s.substring(start+1,end);

        return palStr;
    }

    /**
     * 用穷举法求出最长Palindrome串
     *
     * @param s
     * @return
     */
    public String longestPalindromeByForce(String s){

        if(s==null || s.isEmpty()){
            return null;
        }
        if(s.length()==1){
            return s;
        }
        // 初始化最大回文串的参数
        int maxPalLength=0;
        String maxPalStr=s.substring(0,1);

        // 穷举
        for (int i=0;i<s.length();i++){
            for (int j=i+1;j<s.length();j++){
                String subStr=s.substring(i,j+1);
                int subLength=j+1-i;
                if(isPalindrome(subStr)){
                    if(subLength>maxPalLength){
                        maxPalLength=subLength;
                        maxPalStr=subStr;
                    }
                }
            }
        }
        return maxPalStr;
    }
    /**
     * 判断一个字符串是不是回文串
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s){

        boolean palFlg=true;
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                palFlg=false;
            }
        }
        return palFlg;
    }

    public static void main(String[] args) {

        LongestPalSub longestPalSub=new LongestPalSub();
        String s=longestPalSub.longestPalindromeByForce("abcda");
        System.out.println(s);
    }
}
