package com.lingyejun.leetcode;

/**
 * 26. Remove Duplicates from Sorted Array
 * <p>
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 *
 * @Author: LeeChao
 * @Date: 2018/10/31
 * @Describe:
 * @Modified By:
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * 给定的数组已经是排好顺序的了，判断是否重复的依据就是相邻的是否相等
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int diffIdx = 0;
        for (int i = 1; i < nums.length; i = i + 1) {
            // 相等的话代表重复
            if (nums[diffIdx] == nums[i]) {
                continue;
            } else {
                // 移动位置
                nums[diffIdx + 1] = nums[i];
                diffIdx += 1;
            }
        }
        return diffIdx + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray remove = new RemoveDuplicatesFromSortedArray();
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4};
        int[] num1 = new int[]{0, 0, 1, 1};
        int[] num2 = new int[]{0, 1};
        int num = remove.removeDuplicates(num2);
        System.out.println(num);
    }

}
