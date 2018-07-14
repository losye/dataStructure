题目描述
==============

在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，

重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

```java
public class ListNode {

    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode temp = new ListNode(0);
        temp.next = pHead;
        pHead = temp;
        while(pHead.next!=null && pHead.next.next!=null){
        if(pHead.next.val == pHead.next.next.val){
            int val = pHead.next.val;
                while( pHead.next != null && pHead.next.val == val){
                    
                    pHead.next = pHead.next.next;
                 
                }
        }else{
                pHead = pHead.next;
            }
        }
        return temp.next;
    }
}
```