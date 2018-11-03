package com.lingyejun.com;

/**
 * Two Sum
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @Author: Lingye
 * @Date: 2018/11/3
 * @Describe:
 * @Modified By:
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] inside = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    inside[0] = i < j ? i : j;
                    inside[1] = j > i ? j : i;
                }
            }
        }
        return inside;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3,4,3,90};
        int[] inside = new TwoSum().twoSum(nums, 0);
        System.out.println(inside[0] +" "+inside[1]);
    }
}
