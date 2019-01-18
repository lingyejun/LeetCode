package com.lingye.leetcode;

public class AddTwoNumbers {

    public ListNode addTwoNumbersByString(ListNode l1, ListNode l2) {

        String s1 = "";
        String s2 = "";
        //将l1转为String
        while (l1 != null) {
            s1 += String.valueOf(l1.val);
            l1 = l1.next;
        }
        //将l2转为String
        while (l2 != null) {
            s2 += String.valueOf(l2.val);
            l2 = l2.next;
        }
        String a1 = "";
        String a2 = "";
        //将String倒转
        for (int i = s1.length() - 1; i >= 0; i--) {
            a1 += s1.charAt(i);
        }
        for (int i = s2.length() - 1; i >= 0; i--) {
            a2 += s2.charAt(i);
        }
        int x = Integer.valueOf(a1) + Integer.valueOf(a2);

        String a3 = "";
        for (int i = String.valueOf(x).length() - 1; i >= 0; i--) {
            a3 += String.valueOf(x).charAt(i);
        }

        ListNode result = new ListNode(Integer.valueOf(a3));

        return result;

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        return addPerBit(l1,l2,0);
    }

    /**
     * 思路：开启来是逆序其实按照加法计算，规则还是没有变的
     * l1的每一位+l2的每一位+上一次加完进位=结果中的一位
     * 结果中的当前位=sum%10
     * 给下一位进位=sum/10
     *
     * @param l1
     * @param l2
     * @param carry
     * @return
     */
    public ListNode addPerBit(ListNode l1, ListNode l2, int carry) {

        //两个数都为空，则说明到此递归结束，根据进位carry的数判断最后一位
        if (l1 == null && l2 == null) {
            if (carry == 0) {
                return null;
            }
            return new ListNode(carry);
        }
        //l1不为空，l2为空则将l2补0继续做加法
        if (l1 != null && l2 == null) {
            l2 = new ListNode(0);
        }
        //l1为空，l2不为空则将l1补0继续做加法
        if (l1 == null && l2 != null) {
            l1 = new ListNode(0);
        }
        //第一次调用时carry为0
        int sum = l1.val + l2.val + carry;
        //下次调用的carry
        carry = sum / 10;

        ListNode currNode = new ListNode(sum % 10);
        //递归调用
        currNode.next = addPerBit(l1.next, l2.next, carry);

        return currNode;

    }


    public static void main(String[] args) {

        ListNode ln1 = new ListNode(2);
        ListNode ln2 = new ListNode(4);
        ListNode ln3 = new ListNode(3);
        ln1.next = ln2;
        ln2.next = ln3;

        ListNode ln4 = new ListNode(5);
        ListNode ln5 = new ListNode(6);
        ListNode ln6 = new ListNode(4);
        ln4.next = ln5;
        ln5.next = ln6;

        AddTwoNumbers a = new AddTwoNumbers();
        ListNode x = a.addTwoNumbers(ln1, ln4);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
