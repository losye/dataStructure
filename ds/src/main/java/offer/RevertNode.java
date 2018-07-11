package offer;

/**
 * Created by losye
 * 反转链表
 */
public class RevertNode {
    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    //递归
    public static Node revertRec(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node next = head.next;
        head.next = null;
        revertRec(next);
        next.next = head;
        return head;
    }

    public static Node revert(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node pre = null;
        Node revert = null;
        Node temp = head;
        Node next = null;
        while (temp != null){
            next = temp.next;
            if (next == null){
                revert = temp;
            }
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        return revert;
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
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("before revert:   ");
        printNode(node1);

        System.out.println("after revert:   ");
        printNode(revertRec(node1));
    }
}
