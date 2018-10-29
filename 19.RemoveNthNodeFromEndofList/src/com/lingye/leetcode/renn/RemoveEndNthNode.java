package com.lingye.leetcode.renn;

import java.util.List;

/**
 * 19.Remove Nth Node From End of List
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 *
 * @Author: LeeChao
 * @Date: 2018/10/29
 * @Describe:
 * @Modified By:
 */
public class RemoveEndNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 删第一个节点
        if (n == length(head)) {
            return head.next;
        }
        // 删除中间节点，m为中间第几个
        int m = length(head) - n + 1;
        // 被删除节点的前面和后面
        ListNode preList = head;
        ListNode backList = head.next;
        int idx = 1;
        while (preList != null && backList!=null) {
            if (idx == m - 1) {
                // 判断是否为Null,是否是最后一个节点
                if (backList.next == null) {
                    preList.next = null;
                    break;
                }
                preList.next = backList.next;
                break;

            }
            // 指向下一个
            preList = preList.next;
            backList = preList.next;
            idx++;
        }
        return head;
    }

    public ListNode oldRemoveNthFromEnd(ListNode head, int n) {
        // 计算总长度，将倒数转为正数
        int m = length(head) - n + 1;
        // 将第m-1个Node的next指向第m+1
        int idx = 0;
        ListNode curNode = head;
        // 存储删除节点的前后ListNode
        ListNode preList = null;
        ListNode preHead = null;
        ListNode nextList = null;
        ListNode returnNode = null;
        // 取出要删除的节点前面和后面的串
        while (curNode != null) {
            idx += 1;
            if (idx <= m - 1) {
                ListNode temp = new ListNode(curNode.val);
                if (preList == null) {
                    preList = temp;
                    preHead = preList;
                } else {
                    preList.next = temp;
                    preList = preList.next;
                }
            }
            if (idx == m + 1) {
                nextList = curNode;
            }
            curNode = curNode.next;
        }
        returnNode = preHead;
        while (true) {
            if (preList.next != null) {
                preList = preList.next;
            } else {
                if (preList != null){
                    preList.next = nextList;
                }
                break;
            }
        }
        return returnNode;
    }

    public int length(ListNode listNode){
        if (listNode == null){
            return 0;
        }
        int length = 1;
        ListNode temp = listNode;
        while (temp.next != null) {
            length = length + 1;
            if (temp.next != null) {
                temp = temp.next;
            } else {
                break;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        ListNode newList = new RemoveEndNthNode().removeNthFromEnd(listNode1,3);
        //System.out.println(listNode1.length());
    }
}
class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }
}