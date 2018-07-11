package offer;

/**
 * Created by losye
 * 从尾到头打印链表
 */
public class PrintNodeEnd2Head {
    public static class Node{
        private String value;
        private Node next;

        public Node(String value){
            this.value = value;
        }
    }
    //递归 相当于 用一个辅助栈来完成 当心StackOverFlow
    public static void printNoe(Node head){
        if (head != null){
            if (head.next != null){
                printNoe(head.next);
            }
            System.out.print(head.value + " ");
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node("v1");
        Node n2 = new Node("v2");
        Node n3 = new Node("v3");
        Node n4 = new Node("v4");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        printNoe(n1);
    }
}
