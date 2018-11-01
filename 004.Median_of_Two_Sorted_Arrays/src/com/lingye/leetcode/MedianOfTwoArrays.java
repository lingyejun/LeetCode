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

        int total=m+n;

        if(total%2==0){
            return (findKthInTwoSoredArray(nums1,0,m,nums2,0,n,total/2)+findKthInTwoSoredArray(nums1,0,m,nums2,0,n,total/2 +1))/2;
        }else{
            return findKthInTwoSoredArray(nums1,0,m,nums2,0,n,total/2);
        }
    }

    /**
     * 分治法，为了避免将两个数组完整的遍历一遍
     * 寻找两个数组各自一部分，如A数组的前p个元素和B数组前q个元素
     * 使得p+q=k
     * 为什么需要递归，因为需要去平衡p和q如A'length=4，B'length=5，寻找这两个数组中第5小的元素。
     * p+q=5的组合有很多种，如第5小的元素有可能为A数组的第一个，也有可能为第二、三、四个。
     *
     * @param arrayA 数组A
     * @param startA 数组A的起始点，起始为0
     * @param lengthA 数组A的子数组长度
     * @param arrayB 数组B
     * @param startB  数组B的起始点，起始为0
     * @param lengthB 数组B的子数组长度
     * @return
     */
    public int findKthInTwoSoredArray(int[] arrayA, int startA, int lengthA, int[] arrayB, int startB, int lengthB,int k) {

        // 始终保证A数组的长度小于等于B数组
        if(lengthA>lengthB){
            return findKthInTwoSoredArray(arrayB,startB,lengthB,arrayA,startA,lengthA,k);
        }
        // 当一个数组全部被抛弃时直接返回另外
        if(lengthA==0){
            return arrayB[startB+k-1];
        }
        // 查找第一个元素时直接比较两数组第一个值然后返回
        if(k==1){
            return Math.min(arrayA[startA],arrayB[startB]);
        }
        // 先将k二分-->确定p、q
        int pa=Math.min(k/2,lengthA);
        int pb=k-pa;

        // 二分之后需要多次递归去纠正和平衡p、q
        // 如果A数组第pa个元素小于B数组前pb个元素，因为数组是有序的，我们不能保证B数组第pb个元素比k大还是比k小
        // 但是可以肯定A数组前pa个元素全部比k小，即k肯定不在前pa个小组中，我们就可以将其去除
        if(arrayA[startA+pa-1]<arrayB[startB+pb-1]){
            // 这种情况说明一开始pa选择太偏左了，正确的数可能在k/2的右边，即pa>k/2,即把A数组k/2左边的全部抛弃
            return findKthInTwoSoredArray(arrayA,startA+pa,lengthA-pa,arrayB,startB,lengthB,k-pa);

        }else if(arrayA[startA+pa-1]>arrayB[startB+pb-1]){
            // 这种情况说明pb选的太偏左了，或者说pa选的太偏右了，即pa<k/2
            return findKthInTwoSoredArray(arrayA,startA,lengthA,arrayB,startB+pb,lengthB-pb,k-pb);
        }else{
            return arrayA[startA+pa-1];
        }

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
        int[] aa = {1,3};
        int[] bb = {2};
        double y=medianOfTwoArrays.findMedianByNormal(aa,bb);
        //int x=medianOfTwoArrays.findKthInTwoSoredArray(a,0,a.length,b,0,b.length,5);


//        int[] c = medianOfTwoArrays.mergeSortedArray(a, b);
//        int d = medianOfTwoArrays.findMedianByNormal(a, b);
    }
}
