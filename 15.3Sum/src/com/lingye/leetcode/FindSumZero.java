package com.lingye.leetcode;

import java.util.*;

/**
 * @Author: LeeChao
 * @Date: 2017/12/16
 * @Describe:
 * @Modified By:
 */
public class FindSumZero {

    /**
     * 给一个int数组，求这个数组中的3个数加起来为0 a+b+c=0
     * 那么得出 a b c中肯定有负数，且负数之和的绝对值==正数
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums){

        // 总的返回结果
        List<List<Integer>> resultSet=new ArrayList<>();

        // 存放每一组满足条件的结果
        List<Integer> result=null;

        int index=0;
        int min,middle,max;

        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                index=j+1;
                while (index<nums.length){
                    if(nums[i]+nums[j]+nums[index]==0){
                        result=new ArrayList<Integer>();

                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[index]);
                        // 在登记后满足条件时按照从小到大的顺序
                        Collections.sort(result);
                        // 不重复则添加进去
                        if(!resultSet.contains(result)){
                            resultSet.add(result);
                        }
                    }
                    index++;
                }
            }
        }

        return resultSet;
    }

    public List<List<Integer>> threeSumA(int[] nums){

        // 总的返回结果
        List<List<Integer>> resultSet=new ArrayList<>();

        // 存放每一组满足条件的结果
        List<Integer> result=null;

        int leftIndex;
        int rightIndex;

        for (int i=0;i<nums.length;i++){
            leftIndex=i+1;
            rightIndex=i+2;
            while (leftIndex< nums.length && rightIndex<nums.length){
                if(nums[i]+nums[leftIndex]+nums[rightIndex]==0) {
                    result = new ArrayList<Integer>();

                    result.add(nums[i]);
                    result.add(nums[leftIndex]);
                    result.add(nums[rightIndex]);
                    // 在登记后满足条件时按照从小到大的顺序
                    Collections.sort(result);
                    // 不重复则添加进去
                    if (!resultSet.contains(result)) {
                        resultSet.add(result);
                    }
                }
                rightIndex++;
                if(rightIndex==nums.length){
                    leftIndex++;
                    rightIndex=leftIndex+1;
                }
            }
        }

        return resultSet;
    }

    public List<List<Integer>> threeSumB(int[] nums){

        // 总的返回结果
        List<List<Integer>> resultSet=new ArrayList<>();

        // 存放每一组满足条件的结果
        List<Integer> result=null;

        // 先排序
        Arrays.sort(nums);

        // 指定首和尾下标
        int startIndex;
        int endIndex;
        // 不重复集合 来判断是否已存入
        Set<List<Integer>> set=new HashSet<List<Integer>>();

        for (int i=0;i<nums.length-2;i++){
            startIndex=i+1;
            endIndex=nums.length-1;
            while (startIndex<=nums.length-2 && startIndex<endIndex){
                int sum=nums[i]+nums[startIndex]+nums[endIndex];
                if(sum==0){
                    result = new ArrayList<Integer>();

                    result.add(nums[i]);
                    result.add(nums[startIndex]);
                    result.add(nums[endIndex]);
                    // 在登记后满足条件时按照从小到大的顺序
                    Collections.sort(result);
                    // 不重复则添加进去
                    // 这里容易出现超时！！！！
                    /*if (!resultSet.contains(result)) {
                        resultSet.add(result);
                    }*/
                    // 合理的选择数据结构进行筛选！！！
                    if(set.add(result)){
                        resultSet.add(result);
                    }
                    startIndex++;
                    endIndex--;
                }else if (sum<0){
                    startIndex++;
                }else {
                    endIndex--;
                }
            }
        }
        return resultSet;
    }

    public static void main(String[] args) {

        FindSumZero findSumZero=new FindSumZero();
        int[] nums={-1, 0, 1, 2, -1, -4};

        List<List<Integer>> list=findSumZero.threeSumB(nums);
    }
}
