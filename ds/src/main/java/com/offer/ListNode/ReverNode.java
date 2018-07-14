package com.offer.ListNode;

/**
 * 反转链表
 *
 * @author zzy
 */
public class ReverNode {
    //非递归
    public static Node reverseUnRecur(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node next = null;
        Node cur = head;
        while (cur != null) {
            //记住当前节点的next
            next = cur.next;
            //当前节点指向前一个节点
            cur.next = pre;
            //让pre记住当前节点
            pre = cur;
            //当前节点后移
            cur = next;
        }
        return pre;
    }

    //递归
    public static Node reverseRecur(Node head) {
        //递归相当于压了函数栈，栈中保存当前变量的值
        if (head == null || head.next == null) {
            return head;
        }
        Node next = head.next;
        head.next = null;
        //想象一下，压到最后一层返回的head(revNode)就是尾节点
        Node revNode = reverseRecur(next);
        //此时的next和head是上一个函数栈中的数据
        next.next = head;
        return revNode;
    }

    class Node {
        int val;
        Node next;
    }
}
