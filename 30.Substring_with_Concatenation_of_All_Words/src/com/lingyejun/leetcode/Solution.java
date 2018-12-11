package com.lingyejun.leetcode;

import java.util.List;

/**
 * @Author: lingyejun
 * @Date: 2018/12/9
 * @Describe:
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once
 * and without any intervening characters.
 *
 * Example 1:
 * Input:
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 *
 * Example 2:
 * Input:
 * s = "wordgoodstudentgoodword",
 * words = ["word","student"]
 * Output: []
 *
 * @Modified By:
 */
public class Solution {

    /**
     * Substring with Concatenation of All Words
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findSubstring("",null);
    }
}
