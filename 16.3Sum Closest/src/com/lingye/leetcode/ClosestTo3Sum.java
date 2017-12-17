package com.lingye.leetcode;

import java.util.Arrays;

/**
 * @Author: LeeChao
 * @Date: 2017/12/17
 * @Describe:
 * @Modified By:
 */
public class ClosestTo3Sum {

    /**
     * 整数数组中的三个数相加和目标值最接近的和
     * 思路：和求和一样寻找target-sum=0或者最接近的即可
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target){

        int closest=0;
        // 先对数组排序
        Arrays.sort(nums);
        // 设立最小间距初始值
        int minInterval = 1000;
        // 设立左右下标
        int leftIndex=0;
        int rightIndex=nums.length-1;
        for (int i=0;i<nums.length-2;i++){
            leftIndex=i+1;
            rightIndex=nums.length-1;
            while (leftIndex<rightIndex && leftIndex<=nums.length-2){
                int sum=nums[i]+nums[leftIndex]+nums[rightIndex];
                if(sum>target){
                    rightIndex--;
                }else {
                    leftIndex++;
                }
                if(Math.abs(sum-target)<Math.abs(minInterval)){
                    minInterval=sum-target;
                    closest=sum;
                }
            }
        }
        return closest;
    }
    public static void main(String[] args) {

        ClosestTo3Sum closestTo3Sum=new ClosestTo3Sum();
        int[] nums={-1,2,1,-4};
        int target=1;
        System.out.println(closestTo3Sum.threeSumClosest(nums,target));
    }
}
