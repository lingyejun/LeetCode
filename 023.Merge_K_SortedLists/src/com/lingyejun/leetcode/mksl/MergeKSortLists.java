package com.lingyejun.leetcode.mksl;

/**
 * @Author: Lingye
 * @Date: 2018/11/18
 * @Describe: Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * Example:
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * @Modified By:
 */
public class MergeKSortLists {

    /**
     * 分治法进行合并 12-6-3-2-1
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int n = lists.length;
        while (n > 1) {
            int k = (n + 1) / 2;
            for (int i = 0; i < n / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[i + k]);
            }
            n = k;
        }
        return lists[0];
    }

    /**
     * mergeTwoLists
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode listNode;
        if (l1.val < l2.val) {
            listNode = l1;
            listNode.next = mergeTwoLists(l1.next, l2);
        } else {
            listNode = l2;
            listNode.next = mergeTwoLists(l1, l2.next);
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
        // 创建多个链表
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        listNode4.next = listNode5;
        printListNode(listNode);
        printListNode(listNode2);
        printListNode(listNode4);
        ListNode[] lists = {listNode,listNode2,listNode4};
        ListNode mergeList = new MergeKSortLists().mergeTwoLists(listNode4,listNode);
        printListNode(mergeList);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}