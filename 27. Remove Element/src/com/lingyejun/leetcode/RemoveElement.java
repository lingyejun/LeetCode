package com.lingyejun.leetcode;

/**
 * 27. Remove Element
 * <p>
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * @Author: LeeChao
 * @Date: 2018/10/31
 * @Describe:
 * @Modified By:
 */
public class RemoveElement {

    /**
     * 删除数组中的指定元素
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        // 特殊情况直接返回
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 将要删除的元素放置到尾部
        int idx = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i >= idx) {
                break;
            }
            if (nums[i] == val) {
                if (nums[idx] == val) {
                    idx--;
                    // 遍历直至找到不同的
                    for (int j = idx; j > i; j--) {
                        if (nums[j] != val) {
                            int temp = nums[i];
                            nums[i] = nums[idx];
                            nums[idx] = temp;
                            idx--;
                            break;
                        }
                        idx--;
                    }
                } else {
                    int temp = nums[i];
                    nums[i] = nums[idx];
                    nums[idx] = temp;
                    idx--;
                }
            }
        }
        return idx + 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int[] ab = new int[]{3, 2, 2, 3};
        int[] abc = new int[]{3, 3,3};
        int[] abcd = new int[]{1};
        int val = 3;
        RemoveElement removeElement = new RemoveElement();
        int length = removeElement.removeElement(abc, val);
        System.out.println(length);
    }
}
