package com.lingye.leetcode;

/**
 * @Author: LeeChao
 * @Date: 2017/12/15
 * @Describe:
 * @Modified By:
 */
public class ContainerMostWater {

    public int maxArea(int[] height){
        int maxArea=0;
        if (height.length<2){
            return maxArea;
        }
        if (height.length==2){
            maxArea=Math.min(height[0],height[1])*(1-0);
        }
        for (int i=0;i<height.length;i++){
            for (int j=i+1;j<height.length;j++){
                maxArea=Math.max(maxArea,Math.min(height[i],height[j])*(j-i));
            }
        }
        return maxArea;
    }

    /**
     *  (1 短边决定水箱的有效高，底要尽可能的宽。
     * （2 典型的双指针求解的题型。
     * （3 贪心的策略，哪条边短，往里收缩寻找下一条边。
     *
     * @param height
     * @return
     */
    public int maxAreaA(int[] height){
        int maxArea=0;
        if (height.length<2){
            return maxArea;
        }
        if (height.length==2){
            maxArea=Math.min(height[0],height[1])*(1-0);
        }
        int leftIndex=0;
        int rightIndex=height.length-1;
        int temp=0;
        while (leftIndex<rightIndex){
            temp=Math.min(height[leftIndex],height[rightIndex])*(rightIndex-leftIndex);
            maxArea=Math.max(temp,maxArea);
            // 平衡短板的长度,求最长的短板 如 2，3，5，7 短板就5  2，4，7，6，8
            if(height[leftIndex]<height[rightIndex]){
                leftIndex++;
            }else {
                rightIndex--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        ContainerMostWater containerMostWater=new ContainerMostWater();
        int[] height={2,4,7,6,8};
        System.out.println(containerMostWater.maxAreaA(height));
    }
}
