package cn.newcoder.tree;

import org.junit.Test;
/**
 * 给定一颗完全二叉树的头节点head，求节点个数
 * @author zzy
 * 完全二叉树，除了最后一层，上面都是满的。
 */
public class CompleteTreeNodeNumber {
	public class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public int nodeNum(Node head) {
		if (head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}

	public int bs(Node node, int l, int h) {
		if (l == h) {
			return 1;
		}
		//右子树的最左节点达到最后一层
		if (mostLeftLevel(node.right, l + 1) == h) {
			//说明左子树是满二叉树
			return (1 << (h - l)) + bs(node.right, l + 1, h);
		} else {
			//右子树的上一层是满二叉树
			return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
		}
	}
	/**
	 * 二叉树的深度
	 * @param node
	 * @param level
	 * @return
	 */
	public int mostLeftLevel(Node node, int level) {
		while (node != null) {
			level++;
			node = node.left;
		}
		return level - 1;
	}

	@Test
	public void test() {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(nodeNum(head));

	}

}
 
