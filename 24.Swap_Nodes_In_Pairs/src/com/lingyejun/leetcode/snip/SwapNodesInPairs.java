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
        // 0
        ListNode swappedHead = new ListNode(0);
        // 0-->1-->2-->3-->4
        swappedHead.next = head;
        // pre : 0-->1-->2-->3-->4
        ListNode pre = swappedHead;
        // cur : 1-->2-->3-->4
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            pre.next = cur.next;// 0-->2
            cur.next = cur.next.next;// 1-->3
            pre.next.next = cur; // 2-->1
            // 0-->2-->1-->3
            pre = cur;
            cur = cur.next;
        }
        return swappedHead.next;
    }

    public static void printListNode(ListNode ln) {
        System.out.print(ln.val);
        while (ln.next != null) {
            ln = ln.next;
            System.out.print("->" + ln.val);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 创建多个链表
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(3);
        listNode1.next=listNode2;
        ListNode listNode3 = new ListNode(4);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(5);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(6);
        listNode4.next=listNode5;
        SwapNodesInPairs snip = new SwapNodesInPairs();
        snip.printListNode(listNode);
        ListNode newList = snip.swapPairs(listNode);
        snip.printListNode(newList);
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
