package com.offer.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将一个二叉搜索树转化成一个双端链表
 * @author zzy
 *	1.Converter1   由于搜索树的结构(左小右大),利用先序遍历 每次遍历的Node add 到 List中
 *  2.Converter2 如果有一个函数能返回某个节点下的链表结构，那么对于整个树就是递归调用。 这个方法记录下，还未看懂。
 */
public class BST2DoubleLinkedList {
	
	public static class Node{
		private int value;
		private Node left;
		private Node right;
		
		public Node(int value){
			this.value = value;
		}
	}
	
	public static Node convert1(Node head) {
		Queue<Node> queue = new LinkedList<Node>();
		inOrderToQueue(head, queue);
		if (queue.isEmpty()) {
			return head;
		}
		head = queue.poll();
		Node pre = head;
		pre.left = null;
		Node cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			pre.right = cur;
			cur.left = pre;
			pre = cur;
		}
		pre.right = null;
		return head;
	}

	public static void inOrderToQueue(Node head, Queue<Node> queue) {
		if (head == null) {
			return;
		}
		inOrderToQueue(head.left, queue);
		queue.offer(head);
		inOrderToQueue(head.right, queue);
	}

	public static Node convert2(Node head) {
		if (head == null) {
			return null;
		}
		Node last = process(head);
		head = last.right;
		last.right = null;
		return head;
	}

	public static Node process(Node head) {
		if (head == null) {
			return null;
		}
		Node leftE = process(head.left); // left end
		Node rightE = process(head.right); // right end
		Node leftS = leftE != null ? leftE.right : null; // left start
		Node rightS = rightE != null ? rightE.right : null; // right start
		if (leftE != null && rightE != null) {
			leftE.right = head;
			head.left = leftE;
			head.right = rightS;
			rightS.left = head;
			rightE.right = leftS;
			return rightE;
		} else if (leftE != null) {
			leftE.right = head;
			head.left = leftE;
			head.right = leftS;
			return head;
		} else if (rightE != null) {
			head.right = rightS;
			rightS.left = head;
			rightE.right = head;
			return rightE;
		} else {
			head.right = head;
			return head;
		}
	}

	public static void printBSTInOrder(Node head) {
		System.out.print("BST in-order: ");
		if (head != null) {
			inOrderPrint(head);
		}
		System.out.println();
	}

	public static void inOrderPrint(Node head) {
		if (head == null) {
			return;
		}
		inOrderPrint(head.left);
		System.out.print(head.value + " ");
		inOrderPrint(head.right);
	}

	public static void printDoubleLinkedList(Node head) {
		System.out.print("Double Linked List: ");
		Node end = null;
		while (head != null) {
			System.out.print(head.value + " ");
			end = head;
			head = head.right;
		}
		System.out.print("| ");
		while (end != null) {
			System.out.print(end.value + " ");
			end = end.left;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(2);
		head.right = new Node(9);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.left.right.right = new Node(4);
		head.right.left = new Node(7);
		head.right.right = new Node(10);
		head.left.left = new Node(1);
		head.right.left.left = new Node(6);
		head.right.left.right = new Node(8);

		printBSTInOrder(head);
		head = convert1(head);
		printDoubleLinkedList(head);

		head = new Node(5);
		head.left = new Node(2);
		head.right = new Node(9);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.left.right.right = new Node(4);
		head.right.left = new Node(7);
		head.right.right = new Node(10);
		head.left.left = new Node(1);
		head.right.left.left = new Node(6);
		head.right.left.right = new Node(8);

		printBSTInOrder(head);
		head = convert2(head);
		printDoubleLinkedList(head);

	}

	
	
	
}
