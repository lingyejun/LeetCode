package com.lingye.leetcode;

import java.util.*;

/**
 * @Author: LeeChao
 * @Date: 2017/12/17
 * @Describe:
 * @Modified By:
 */
public class SumOf4Num {

    /**
     * 从字符数组中筛选出四数加和=target的所有集合
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target){

        // 先对传入数组进行排序
        Arrays.sort(nums);
        // 初始化返回值
        List<List<Integer>> resultSet=new ArrayList<>();
        // 存放每一组的结果
        List<Integer> result=null;

        // 存放其余三个数字的变量
        int startIndex;
        int endIndex;
        // 不重复集合 来判断是否已存入
        Set<List<Integer>> set=new HashSet<List<Integer>>();

        // 四数加和，想办法调整成3数加和
        for (int i=0;i<nums.length-3;i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                startIndex = j + 1;
                endIndex = nums.length - 1;
                while (startIndex <= nums.length - 2 && startIndex < endIndex) {
                    int sum = nums[i] + nums[j] + nums[startIndex] + nums[endIndex];
                    if (sum == target) {
                        result = new ArrayList<Integer>();

                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[startIndex]);
                        result.add(nums[endIndex]);
                        // 在登记后满足条件时按照从小到大的顺序
                        Collections.sort(result);
                        // 合理的选择数据结构进行筛选！！！
                        if (set.add(result)) {
                            resultSet.add(result);
                        }
                        startIndex++;
                        endIndex--;
                    } else if (sum < target) {
                        startIndex++;
                    } else {
                        endIndex--;
                    }
                }

            }
        }
        return resultSet;
    }

    public static void main(String[] args) {

        SumOf4Num sumOf4Num=new SumOf4Num();
        int[] nums={-3,-1,0,2,4,5};
        int target=2;
        List<List<Integer>> list=sumOf4Num.fourSum(nums,target);
    }
}
