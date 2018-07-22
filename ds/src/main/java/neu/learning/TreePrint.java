package neu.learning;

import neu.learning.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
 *
 * @author Administrator
 */
public class TreePrint {
    public static void main(String[] args) {

    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return result;
        }
        LinkedList<TreeNode> link = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        link.add(pRoot);
        int start = 0, end = 1;
        while (!link.isEmpty()) {
            TreeNode node = link.remove();
            list.add(node.val);
            start++;
            if (node.left != null) {
                link.add(node.left);
            }
            if (node.right != null) {
                link.add(node.right);
            }
            if (start == end) {
                end = link.size();
                start = 0;
                result.add(list);
                list = new ArrayList<Integer>();
            }
        }

        return result;
    }

}
