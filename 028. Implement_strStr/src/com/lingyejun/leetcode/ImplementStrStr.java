package com.lingyejun.leetcode;

/**
 * Implement strStr
 * <p>
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * <p>
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * @Author: LeeChao
 * @Date: 2018/11/1
 * @Describe:
 * @Modified By:
 */
public class ImplementStrStr {

    /**
     * Implement strStr()
     *
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        // if haystack is null or empty,return 0
        if (haystack == null || (haystack.isEmpty() && needle.isEmpty()) || (!haystack.isEmpty() && needle.isEmpty())) {
            return 0;
        }
        // record the needle first occurrence index and init -1
        int idx = -1;
        if (needle.isEmpty() || needle.length()>haystack.length()) {
            return idx;
        }
        int idxNeedle = 0;
        boolean hayFlg = false;
        for (int i = 0; i < haystack.length(); i++) {
            int j = i;
            while (idxNeedle < needle.length() && j<haystack.length()) {
                if (haystack.charAt(j) != needle.charAt(idxNeedle)) {
                    idxNeedle = 0;
                    break;
                }
                idxNeedle++;
                j++;
                if (idxNeedle == needle.length()) {
                    hayFlg = true;
                }
            }
            if (hayFlg) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    public static void main(String[] args) {

        ImplementStrStr iss = new ImplementStrStr();
        String haystack = "hello";
        String needle = "ll";
        String haystack1 = "mississippi";
        String needle1 = "issipi";
        //System.out.println(iss.strStr(haystack, needle));
        System.out.println(iss.strStr(haystack1, needle1));
    }
}
