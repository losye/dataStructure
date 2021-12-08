//给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
//
// 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
//
//
//
// 示例 1：
//
//
//
// 输入：root = [1,7,0,7,-8,null,null]
//输出：2
//解释：
//第 1 层各元素之和为 1，
//第 2 层各元素之和为 7 + 0 = 7，
//第 3 层各元素之和为 7 + -8 = -1，
//所以我们返回第 2 层的层号，它的层内元素之和最大。
//
//
// 示例 2：
//
// 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
//输出：2
//
//
//
//
// 提示：
//
//
// 树中的节点数介于 1 和 10^4 之间
// -10^5 <= node.val <= 10^5
//
// Related Topics 树 广度优先搜索 二叉树
// 👍 47 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumLevelSumOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumLevelSumOfABinaryTree().new Solution();
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

        private int res = 0;

        private int max = Integer.MIN_VALUE;


        public int maxLevelSum(TreeNode root) {
            if (root == null) {
                return res;
            }
            Deque<TreeNode> queue = new LinkedList<>();
            queue.addFirst(root);
            int level = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                int sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.pollFirst();
                    sum += node.val;
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                }
                if (max < sum) {
                    max = sum;
                    res = level;
                }
                level++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
