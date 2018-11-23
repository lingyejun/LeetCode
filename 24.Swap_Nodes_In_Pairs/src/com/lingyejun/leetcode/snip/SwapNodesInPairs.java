package com.lingyejun.leetcode.snip;

/**
 * @Author: lingyejun
 * @Date: 2018/11/23
 * @Describe:
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * @Modified By:
 */
public class SwapNodesInPairs {

    /**
     * 0-->1-->2-->3-->4
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode swappedHead = head;
        swappedHead.next = head;
        while (head.next!=null){

        }
        return swappedHead;
    }

    public static void main(String[] args) {

    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
