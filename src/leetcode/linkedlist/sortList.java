package leetcode.linkedlist;

import org.junit.Test;

/**
 * ${DESCRIPTION}
 *
 * @author zhangzhengye
 * @create 2017-11-19 下午4:37
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 */
public class sortList {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //now slow is in middle
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        //now left and right is sorted
        return merge(left, right);

    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode tempHead = new ListNode(0);
        ListNode tempNode = tempHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tempNode.next = left;
                left = left.next;
            } else {
                tempNode.next = right;
                right = right.next;
            }
            tempNode = tempNode.next;
        }
        if (left != null)
            tempNode.next = left;
        if (right != null)
            tempNode.next = right;
        return tempHead.next;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(7);
        listNode.next = new ListNode(5);
        listNode.next = new ListNode(3);
        listNode.next = new ListNode(4);
        new sortList().sortList(listNode);
    }



}
