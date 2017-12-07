package com.lingye.leetcode;

public class MedianOfTwoArrays {

    /**
     * 求两个已排序数组的中位数
     * 思路：
     * 1.这两个数组是已经排序好的了
     * 2.如果长度是奇数则是第n/2+1，偶数则是(n/2+(n/2+1))/2
     * 3.我们就想办法找到已排序两个数组的2/n是哪个数就好了
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1,int[] nums2){

        // 计算两个数组的长度
        int m=nums1.length;
        int n=nums2.length;

        //两个数组的组合后的总长度
        int totalLength=m+n;

        // 定义新的数据用来记录两个数组排序好后的结果
        int[] totalArray=new int[totalLength];

        //如果总长度为偶数则为中间两个数除以2
        if(totalLength%2==0){
            //一次遍历就要放置正确所以要用两个变量记录输入数组移动情况
            for(int i=0;i<totalLength;i++){
                if(i<m && i<n ){
                    if(nums1[i]<nums2[i]){
                        totalArray[i]=nums1[1];
                    }
                }
            }
        }


        return 0.00;
    }

    /**
     * 用常规排序的方法找中位数
     * 时间复杂度为：O(log(m+n))
     *
     * @param array1
     * @param array2
     * @return
     */
    public int findMedianByNormal(int[] array1, int[] array2) {
        int[] c = mergeSortedArray(array1, array2);
        //总长度为偶数去中间两位的一半
        if (c.length % 2 == 0) {
            int medianA = c.length / 2 - 1;
            int medianB = c.length / 2;

            return (c[medianA] + c[medianB]) / 2;
        }
        return c[((c.length + 1) / 2) - 1];
    }

    /**
     * 时间复杂度为：O(log(m+n))
     *
     * @param array1
     * @param array2
     * @return
     */
    public int[] mergeSortedArray(int[] array1, int[] array2) {

        //获取两数组的长度
        int array1Length = array1.length;
        int array2Length = array2.length;

        //计算合并后的总长度，并创建合并后的数组
        int totalLength = array1Length + array2Length;
        int[] totalArray = new int[totalLength];

        // 记录两个数组和总数组的拷贝位置的变量
        int i = 0;//记录array1数组变量位置
        int j = 0;//记录array2数组变量位置
        int k = 0;//记录total数组变量位置

/*        //将两个数组的值拷贝到总数组中
        while (i < array1Length && j < array2Length) {
            if (array1[i] < array2[j]) {
                totalArray[k++] = array1[i++];
            } else if (array1[i] > array2[j]) {
                totalArray[k++] = array2[j++];
            } else {
                totalArray[k++] = array1[i++];
                totalArray[k++] = array2[j++];
            }
        }

        //除非是两个完全一样的数组，不然肯定完成拷贝的先后顺序
        if (i == array1Length) {
            while (j < array2Length) {
                totalArray[k++] = array2[j++];
            }
        } else {
            while (i < array1Length) {
                totalArray[k++] = array1[i++];
            }
        }*/

        //上面的代码等同于下面的代码
        for (int ak = 0; ak < totalLength; ak++) {
            if (i < array1Length && j < array2Length) {
                if (array1[i] < array2[j]) {
                    totalArray[ak] = array1[i++];
                } else if (array1[i] > array2[j]) {
                    totalArray[ak] = array2[j++];
                } else {
                    totalArray[ak++] = array1[i++];
                    totalArray[ak] = array2[j++];
                }
            } else if (i == array1Length) {
                if(j< array2Length){
                    totalArray[ak] = array2[j++];
                }
            } else if (j == array2Length){
                if(i<array1Length){
                    totalArray[ak] = array1[i++];
                }
            }else{
                break;
            }
        }

        return totalArray;
    }

    public static void main(String[] args) {

        MedianOfTwoArrays medianOfTwoArrays = new MedianOfTwoArrays();
        //int[] a = {1, 2, 3, 4, 5, 6, 7};
        //int[] b = {3, 4, 6, 6, 8, 9, 10, 11, 12};
        int[] a = {1, 2, 3, 7};
        int[] b = {3, 4, 5, 6, 8};
        int[] c = medianOfTwoArrays.mergeSortedArray(a, b);
        int d = medianOfTwoArrays.findMedianByNormal(a, b);
    }
}
