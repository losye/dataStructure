//给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// 进阶：
//
// 你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树
// 👍 1515 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            //return dfs(root.left, root.right);
            return symmetric(root);
        }

        //迭代版本
        private boolean symmetric(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode left = queue.removeFirst();
                TreeNode right = queue.removeFirst();
                if (left == null && right == null) {
                    continue;
                }
                if (left == null || right == null) {
                    return false;
                }

                if (left.val != right.val) {
                    return false;
                }

                queue.add(left.left);
                queue.add(right.right);

                queue.add(left.right);
                queue.add(right.left);
            }

            return true;
        }

        //递归版本
        private boolean dfs(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            return dfs(left.left, right.right) && dfs(left.right, right.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
