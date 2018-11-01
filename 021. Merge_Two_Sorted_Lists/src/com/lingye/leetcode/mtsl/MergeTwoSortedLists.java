package com.lingye.leetcode.mtsl;

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
                /*if (l1 == null) {
            head = l1;
        } else if (l2 == null) {
            head = l2;
        } else {
            ListNode temp = null;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    temp = l1;
                    mergeList.next = temp;
                    temp.next = null;
                    mergeList = temp;
                    l1 = l1.next;
                }else if (l1.val > l2.val) {
                    temp = l2;
                    mergeList.next = temp;
                    temp.next = null;
                    mergeList = temp;
                    l2 = l2.next;
                } else {
                    temp = l1;
                    mergeList.next = temp;
                    temp.next = null;
                    mergeList = temp;
                    l1 = l1.next;

                    temp = l2;
                    mergeList.next = temp;
                    temp.next = null;
                    mergeList = temp;
                    l2 = l2.next;
                }
            }
        }*/
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
        ListNode mergeListNode = new MergeTwoSortedLists().mergeTwoLists(listNode, listNode2);
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