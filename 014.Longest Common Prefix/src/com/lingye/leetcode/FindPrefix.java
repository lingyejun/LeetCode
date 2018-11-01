package com.lingye.leetcode;

/**
 * @Author: LeeChao
 * @Date: 2017/12/16
 * @Describe:
 * @Modified By:
 */
public class FindPrefix {

    /**
     * 从字符数组中找出它们公共前缀！子串
     * 思路：
     *
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs){

        // 特殊情况返回
        if(strs==null || strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        String result="";
        // 设置默认最短字符串
        int minLen=strs[0].length();
        String minStr=strs[0];
        // 先找到字符数组中最短的字符串
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<minLen){
                minLen=strs[i].length();
                minStr=strs[i];
            }
        }
        // 遍历最短的字符串
        for (int i=0;i<minLen;i++){
            boolean addFlg=true;
            // 因为寻找的是公共前缀只要最短的和其余字符串第一个不等那么就是空
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i)!=minStr.charAt(i)){
                    addFlg=false;
                    break;
                }
            }
            if(addFlg){
                result+=minStr.charAt(i);
            }else {
                break;
            }
        }

        return result;
    }
    public static void main(String[] args) {

        String a1="aca";
        String a2="acba";
        String[] strs={a1,a2};
        FindPrefix findPrefix=new FindPrefix();
        String prefix=findPrefix.longestCommonPrefix(strs);
        System.out.println(prefix);
    }
}
