package com.lingye.leetcode.renn;

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
        // 计算总长度，将倒数转为正数
        int m = head.length() - n + 1;
        // 将第m-1个Node的next指向第m+1
        int idx = 0;
        ListNode curNode = head;
        // 存储删除节点的前后ListNode
        ListNode preList = null;
        ListNode nextList = null;
        ListNode returnNode = null;
        // 取出要删除的节点前面和后面的串
        while (curNode != null) {
            idx += 1;
            if (idx <= m - 1) {
                ListNode temp = new ListNode(curNode.val);
                if (preList == null) {
                    preList = temp;
                } else {
                    preList.next = temp;
                }
            }
            if (idx == m + 1) {
                nextList = curNode;
            }
            curNode = curNode.next;
        }
        returnNode = preList;
        while (true) {
            if (preList.next != null) {
                preList = preList.next;
            } else {
                preList.next = nextList;
                break;
            }
        }
        return returnNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        ListNode newList = new RemoveEndNthNode().removeNthFromEnd(listNode1,3);
        System.out.println(listNode1.length());
    }
}
class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    int length() {
        int length = 1;
        ListNode temp = this;
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
}