题目描述
================

public class ListNode {

    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead){
       if(pHead == null || pHead.next == null){
           return null;
       }
        ListNode node1 = pHead;
        ListNode node2 = pHead;
        while(node2 != null){
            node1 = node1.next;
            node2 = node2.next.next;
            if(node1 == node2){
                break;
            }
        }
        node1 = pHead;
        while(node1 != node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
}


一个快指针，一个慢指针问题
