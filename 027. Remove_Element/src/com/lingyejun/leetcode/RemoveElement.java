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
    public int oldRemoveElement(int[] nums, int val) {
        // 特殊情况直接返回
        if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] == val)) {
            return 0;
        }
        // 将要删除的元素放置到尾部
        int idx = nums.length - 1;
        // 进行一次数组双向遍历
        for (int i = 0; i < nums.length; i++) {
            // 遇到要删除的元素
            if (nums[i] == val) {
                for (int j = idx; j > i || idx + 1 == nums.length - 1; j--) {
                    // 数组尾部就是要删除的元素，则向前找
                    if (nums[j] == nums[i]) {
                        // 继续找下一个
                        idx--;
                        // 全部为一样的值，全部删除
                        if (i == 0 && idx == i) {
                            return 0;
                        }
                        continue;
                    } else {
                        // 将删除的元素替换
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        idx--;
                        break;
                    }
                }
            } else if (nums.length == 2 && nums[idx] == val) {
                idx--;
            }
            if (idx < i) {
                break;
            }
        }
        return idx + 1;
    }

    /**
     * 直接将不是被删除的元素移到前面去
     * 
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        // 特殊情况直接返回
        int idx = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=val){
                nums[idx++]=nums[i];
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int[] ab = new int[]{3, 2, 2, 3};
        int[] abc = new int[]{3, 3, 3};
        int[] abcd = new int[]{1};
        int[] abcde = new int[]{4, 5};
        int[] abcdef = new int[]{2, 2, 3};
        int val = 3;
        RemoveElement removeElement = new RemoveElement();
        int length = removeElement.removeElement(abcdef, val);
        System.out.println(length);
    }
}
