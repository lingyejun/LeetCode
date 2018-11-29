package com.lingyejun.leetcode.rnikg;

/**
 * @Author: lingyejun
 * @Date: 2018/11/25
 * @Describe: Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * @Modified By:
 */
public class ReverseNodesInKGroup {

    /**
     * ReverseNodesInKGroup
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (length(head) < k) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        // 1-->2-->3-->4
        for (int i = 0; i < k; i++) {
            next = cur.next; // next : 2-->3-->4
            cur.next = prev; // cur : 1
            prev = cur; // prev : 1
            cur = next; // cur : 2
        }
        head.next = reverseKGroup(cur, k);
        return prev;
    }

    /**
     * get list length
     *
     * @param listNode
     * @return
     */
    public static int length(ListNode listNode) {
        int length = 0;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        System.out.println(length);
        return length;
    }

    /**
     * print list
     *
     * @param ln
     */
    public static void printListNode(ListNode ln) {
        System.out.print(ln.val);
        while (ln.next != null) {
            ln = ln.next;
            System.out.print("->" + ln.val);
        }
        System.out.println();
    }

    public static void main(String[] args) {
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
        printListNode(listNode);
        length(listNode);
        ListNode reverseNode = new ReverseNodesInKGroup().reverseKGroup(listNode,2);
        printListNode(reverseNode);
    }

    /**
     * 定义静态内部类
     */
    static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
