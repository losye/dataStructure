package offer;

/**
 * Created by losye
 * O(1)时间删除链表节点
 */
public class DeleteNode {
    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //这里简化了判断node相等 只要value相等可以了
    public static void deleteNode(Node head, Node delete){
        if (head == null){
            return;
        }
        if (head.next == null){
            head = null;
        }
        Node temp = head;
        if (delete != null){

            if (delete.next == null){
                //只能遍历链表删除
                while (temp.next != null ){
                    if (temp.next.value == delete.value){
                        temp.next = null;
                        break;
                    }
                    temp = temp.next;
                }
            }else {
                //把删除节点的next节点数据复制到删除节点 并删除next节点
                delete.value = delete.next.value;
                delete.next = delete.next.next;
            }
        }
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
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println("before delete:   ");
        printNode(node1);
        //deleteNode(node1, node3);
        //deleteNode(node1, node4);
        deleteNode(node1, node1);
        System.out.println("after delete:   ");
        printNode(node1);
    }
}
