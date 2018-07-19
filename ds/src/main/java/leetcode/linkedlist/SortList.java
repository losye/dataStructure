package leetcode.linkedlist;

/**
 * ${DESCRIPTION}
 *
 * @author zhangzhengye
 * @create 2017-11-19 下午4:37
 * <p>
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
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

    private static ListNode merge(ListNode left, ListNode right) {
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

}
