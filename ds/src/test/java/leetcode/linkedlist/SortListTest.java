package leetcode.linkedlist;

import cn.newcoder.other.printArrUtils;
import org.junit.jupiter.api.Test;

/**
 * @Author: zhengye.zhang
 * @Description:
 * @Date: 2018/7/18 下午4:56
 */
class SortListTest {

    @Test
    void sortList() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(7);
        listNode.next.next = new ListNode(5);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        ListNode listNode1 = SortList.sortList(listNode);
        printArrUtils.showNode(listNode1);

    }
}