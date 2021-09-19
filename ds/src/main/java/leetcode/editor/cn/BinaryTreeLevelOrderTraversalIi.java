//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其自底向上的层序遍历为：
//
//
//[
//  [15,7],
//  [9,20],
//  [3]
//]
//
// Related Topics 树 广度优先搜索 二叉树
// 👍 484 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            //递归版本
        /*levelOrder(root, 0);
        Collections.reverse(result);*/

            if (root == null) {
                return result;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                List<Integer> levelList = new ArrayList<>();
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode poll = queue.poll();
                    levelList.add(poll.val);

                    TreeNode left = poll.left;
                    if (left != null) {
                        queue.addLast(left);
                    }
                    TreeNode right = poll.right;
                    if (right != null) {
                        queue.addLast(right);
                    }
                }
                //
                result.add(0, levelList);

            }

            return result;
        }

        private void levelOrder(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (result.size() <= level) {
                List<Integer> levelList = new ArrayList<>();
                result.add(levelList);
            }
            List<Integer> levelList = result.get(level);
            levelList.add(root.val);


            levelOrder(root.left, level + 1);
            levelOrder(root.right, level + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
