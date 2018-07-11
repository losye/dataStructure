package offer;

/**
 * Created by losye
 * 链表中倒数第k个节点
 */
public class FindKth2Tail {
    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    //无需辅助栈结构帮助从尾到头 快慢指针之间相差k步即可
    public static Node find(Node head, int k){
        if (head == null){
            return null;
        }
        Node fast = head;
        //快指针先移动k步
        for (int i=0; i<k-1; i++){
            if (fast.next != null){
                fast = fast.next;
            }else {
                // k > node.size
                return null;
            }
        }
        Node slow = head;

        //慢指针开始移动
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
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
        System.out.println("3th: " + find(node1, 3).value);
        System.out.println("5th: " + find(node1, 5).value);
        System.out.println("6th: " + find(node1, 6));

    }



}
