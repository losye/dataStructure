package offer;

/**
 * Created by losye
 * 合并两个排序链表
 */
public class MergeNodeList {
    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node merge(Node node1, Node node2){
        if (node1 == null){
            return node2;
        }
        if (node2 == null){
            return node1;
        }
        Node res;
        if (node1.value < node2.value){
            res = node1;
            res.next = merge(node1.next, node2);
        }else {
            res = node2;
            res.next = merge(node1, node2.next);
        }
        return res;
    }
    public static void printNode(Node head){
        if (head == null){
            return;
        }
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        Node node4 = new Node(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node node21 = new Node(2);
        Node node22 = new Node(4);
        Node node23 = new Node(6);
        Node node24 = new Node(8);
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        printNode(merge(node1, node21));
    }
}
