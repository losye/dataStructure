package offer;

/**
 * Created by losye
 * 输入两个链表，找出它们的第一个公共节点
 */
public class FindFirstCommNode {
     class Node{
         int val;
         Node next;
         public Node(int val) {
             this.val = val;
         }
     }
    /**
     * 1、只要从尾到头开始找到最后一个相同的节点，引入栈结构即可
     * 2、求2个链表的长度，长度长的先走，确保同时进入相交部分
     */
    public static Node solution(Node n1, Node n2){
         if (n1 == null || n2 == null){
             return null;
         }
         Node shortTmp = n1;
         Node longTmp = n2;
         int n1len = 0;
         int n2len = 0;
         while (shortTmp != null){
             n1len++;
             shortTmp = shortTmp.next;
         }
        while (longTmp != null){
            n2len++;
            longTmp = longTmp.next;
        }
        shortTmp = n1;
        longTmp = n2;
        if (n1len > n2len){
            longTmp = n1;
            shortTmp = n2;
        }
        int gap = Math.abs(n1len-n2len);
        for (int i=0; i<gap; i++){
            longTmp = longTmp.next;
        }
        while (longTmp != null && shortTmp != null && longTmp.val != shortTmp.val){
            longTmp = longTmp.next;
            shortTmp = shortTmp.next;
        }
        return longTmp;
    }

}
