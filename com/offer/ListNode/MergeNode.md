题目描述
=======================
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则


public class ListNode {

    int val;
    ListNode next = null;


    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode res = null;
        if(list1.val > list2.val){
           res = list2;
           res.next = Merge(list1,list2.next);
        }else{
            res = list1;
            res.next = Merge(list1.next,list2);
        }
        return res;
    }
}

解题思路：
===========================
突破口：两个链表都是有序的，那么只要比较两个链表的第一个，小的就是返回的链表头。
对于第二个节点，还是老样子。比较剩下的链表节点的头节点大小，将小的作为res.next
递归就可以完成。
