package neu.learning;

import neu.learning.model.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树的第k个结点
 *
 * @author Administrator 给定一颗二叉搜索树，请找出其中的第k大的结点。
 *                  5
 * 例如:           /  \
 *               3    7
 *              /\    /\
 *             2  4  6  8
 * 中，按结点数值大小顺序第三个结点的值为4。
 */
public class KthNode {

    public static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 1) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int count = 0;
        TreeNode KthNode = null;
        while (pRoot != null || !stack.isEmpty()) {
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            TreeNode node = stack.pop();
            count++;
            if (count == k) {
                KthNode = node;
            }
            //System.out.println(node.val);
            pRoot = node.right;
        }
        return KthNode;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(8);
//		TreeNode n8 = new TreeNode(8);
//		TreeNode n9 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;
        System.out.println(KthNode(n1, 3).val);

    }
}
