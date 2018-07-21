package neu.learning.model;

import java.util.Stack;



public class Node {
	private Node left;
	private Node right;
	private int value;

	public Node(int data) {
		this.value = data;
	}

	// 先序遍历（递归）
	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	// 中序 递归
	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}

	// 后序 递归
	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value + " ");
	}

	// 先序 非递归
	public static void preOrderUnrecur(Node head) {
		if (head != null) {
			Stack<Node> stack = new Stack();
			stack.push(head);
			while (!stack.isEmpty()) {
				head = stack.pop();
				System.out.print(head.value + " ");
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}

	// 中序 非递归
	public static void inOrderUnrecur(Node head) {
		if (head != null) {
			Stack<Node> stack = new Stack();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					System.out.print(head.value + " ");
					head = head.right;
				}
			}
		}
		System.out.println();
	}

	// 后序 非递归 2个栈 
	public static void posOrderUnrecur(Node head) {
		if (head != null) {
			Stack<Node> s1 = new Stack();
			Stack<Node> s2 = new Stack();
			s1.push(head);
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head);				
				if (head.left != null) {
					s1.push(head.left);
				}
				if (head.right != null) {
					s1.push(head.right);
				}
			}
			while(!s2.isEmpty()){
				//head = s2.pop();
				System.out.print(s2.pop().value + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);

		preOrderRecur(node);
		preOrderUnrecur(node);
		inOrderRecur(node);
		inOrderUnrecur(node);
		posOrderRecur(node);
		posOrderUnrecur(node);
	}
}
