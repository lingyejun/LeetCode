package com.lingye.leetcode.mtsl;

import java.util.List;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @Author: LeeChao
 * @Date: 2018/10/27
 * @Describe:
 * @Modified By:
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 初始化ListNode
        ListNode mergeList = new ListNode(-1);
        ListNode mergeNext = mergeList;
        // 依次比较，插入较小的那个
        while (l1 != null || l2 != null) {
            ListNode curNode = null;
            if (l1 == null) {
                curNode = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                curNode = l1;
                l1 = l1.next;
            } else if (l1.val <= l2.val) {
                curNode = l1;
                l1 = l1.next;
            } else if (l2.val < l1.val) {
                curNode = l2;
                l2 = l2.next;
            }
            mergeNext.next = curNode;
            mergeNext = mergeNext.next;
        }
        return mergeList.next;
    }

    public ListNode mergeTwoListsByRecur(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode listNode;
        if (l1.val < l2.val) {
            listNode = l1;
            listNode.next = mergeTwoListsByRecur(l1.next, l2);
        } else {
            listNode = l2;
            listNode.next = mergeTwoListsByRecur(l1, l2.next);
        }
        return listNode;
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
        // 创建两个链表
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode2.next = listNode3;
        printListNode(listNode);
        printListNode(listNode2);
        // 合并
        ListNode mergeListNode = new MergeTwoSortedLists().mergeTwoListsByRecur(listNode, listNode2);
        // 打印
        printListNode(mergeListNode);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}