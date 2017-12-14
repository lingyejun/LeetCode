package com.lingye.leetcode;

/**
 * @Author: LeeChao
 * @Date: 2017/12/15
 * @Describe:
 * @Modified By:
 */
public class RegularMatching {

    /**
     * 用正则去匹配一个指定的字符串
     * A串是指定的字符串，B串是正则字符串
     * 思路：
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        boolean isMatch = false;
        // s 为指定字符串，p为正则字符串
        String givenStr = s;
        String regularStr = p;

        // 如果正则里面直接就包含指定字符则直接返回
        if (regularStr.contains(givenStr)) {
            isMatch = true;
        }
        // 如果正则中没有*且长度比给定的短则直接返回
        if (regularStr.indexOf('*') == -1 && regularStr.length() < givenStr.length()) {
            return isMatch;
        }
        // 如果正则中没有*且没有. 如果长度相等则直接判断，若长度比给定长
        if (regularStr.indexOf('*') == -1 && regularStr.indexOf('.') == -1) {
            if (regularStr.length() == givenStr.length() && regularStr == givenStr) {
                isMatch = true;
            } else if (regularStr.length() > givenStr.length() && regularStr.contains(givenStr)) {
                isMatch = true;
            } else {
                return isMatch;
            }
        } else if (regularStr.indexOf('*') == -1 && regularStr.indexOf('.') > -1) {//如果正则中没有*但是有. 则主要根据长度判断
            // 若正则长与给定字符串，则每次截取givenStr的长度的子串，依次比较每一个字符，遇到.则直接匹配
            if (regularStr.length() > givenStr.length()) {
                for (int i = 0; i < regularStr.length() - givenStr.length(); i++) {
                    String sub = regularStr.substring(i, i + givenStr.length());
                    isMatch=regularLenEqualsGiven(sub, givenStr);
                    if(!isMatch){
                        return isMatch;
                    }
                }
            } else if (regularStr.length() < givenStr.length()) { //长度小于给定字符串直接返回
                return isMatch;
            } else {
                // 两者长度相等，按照上面的方法重新判断一次
                isMatch=regularLenEqualsGiven(regularStr, givenStr);
                if(!isMatch){
                    return isMatch;
                }
            }
        } else if (regularStr.indexOf('*') > -1 && regularStr.indexOf('.') == -1){//如果正则中有*,但是没有.
                //*就是全部匹配，分为字符前*，字符后*，和就一个*
            if(regularStr.length()==1){
                isMatch=true;
            }else if (true){//带*但是不匹配只是个别情况
                //给定
            }

        }
        return isMatch;
    }

    private boolean regularLenEqualsGiven(String regularStr, String givenStr) {
        boolean isMatch = false;
        if (regularStr.equals(givenStr)) {
            isMatch = true;
        } else if (regularStr.indexOf('.') > -1) {
            for (int j = 0; j < givenStr.length(); j++) {
                if (regularStr.charAt(j) != givenStr.charAt(j) && regularStr.charAt(j) != '.') {
                    return isMatch;
                } else if (regularStr.charAt(j) == givenStr.charAt(j) || regularStr.charAt(j) != '.') {
                    continue;
                }
            }
            isMatch = true;
        } else if (regularStr.indexOf('.') == -1) {
            for (int j = 0; j < givenStr.length(); j++) {
                if (regularStr.charAt(j) != givenStr.charAt(j)) {
                    return isMatch;
                }
            }
            isMatch = true;
        }
        return isMatch;
    }

    public boolean isMatchA(String s, String p) {
        // s 为指定字符串，p为正则字符串
        String givenStr = s;
        String regularStr = p;
        boolean isMatch=helper(givenStr,givenStr.length()-1,regularStr,regularStr.length()-1);

        return isMatch;
    }
    /**
     * 正则匹配就是：正则字符串通过. *的帮助能够变大扩容使之包含给定串！
     *
     * 思路：一般正则字符串都是要比待匹配的字符串短
     * 顺着这个思路来找如：
     * givenStr  :aaaaaaaaaaabbc
     * regularStr:a*b*c
     * *代表它前面的字母出现了0次或者n次，那么就意味着*前面一定是由字母或者.
     *
     */
    public boolean helper(String givenStr,int i,String regularStr,int j){

        // 把正则串从尾匹配到头，完全走了一遍，说明这个正则很硬，没有被淘汰掉
        //如果j已经<0了说明regularStr已经匹配完了，这时候，如果s匹配完了，说明正确，如果s没匹配完，说明错误,（正则通过变大还是不能包容给定字符串）
        //如果i已经<0了说明givenStr已经匹配完，这时候，s可以没匹配完，只要它还有”*”存在，我们继续执行代码。（）
        if(j == -1){
            if(i==-1){
                return true;
            }else {
                return false;
            }
        }
        if(regularStr.charAt(j)=='*'){
            // aaabbcc   a*b*.*
            if(i > -1 && j>-1 && (regularStr.charAt(j-1)=='.' || regularStr.charAt(j-1)==givenStr.charAt(i))){
                // aaaaaa a* 因为*可以代表0至多个，所以每当*匹配了(a*) a匹配了given字符串的最后一个，就然given往前看看到底匹配到哪里
                if(helper(givenStr,i-1,regularStr,j)){
                    return true;
                }
            }
            // aaabbcc  a*bbc*d*
            return helper(givenStr,i,regularStr,j-2);
        }else {
            // aaabbcc  .b.c
            if( (i>-1 && j>-1) && (regularStr.charAt(j)=='.' || regularStr.charAt(j)==givenStr.charAt(i))){
                return helper(givenStr,i-1,regularStr,j-1);
            }
            return false;
        }
    }


    public static void main(String[] args) {
            RegularMatching regularMatching=new RegularMatching();
            boolean a=regularMatching.isMatchA("aa","a");
            System.out.println(a);
    }
}
