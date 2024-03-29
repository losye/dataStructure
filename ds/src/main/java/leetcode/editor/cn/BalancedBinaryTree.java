//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//
//
// 示例 3：
//
//
//输入：root = []
//输出：true
//
//
//
//
// 提示：
//
//
// 树中的节点数在范围 [0, 5000] 内
// -104 <= Node.val <= 104
//
// Related Topics 树 深度优先搜索 二叉树
// 👍 759 👎 0


package leetcode.editor.cn;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
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
        public boolean isBalanced(TreeNode root) {
           // return back(root);
            return recur(root) != -1;
        }

        private boolean back(TreeNode root) {
            if (root == null) {
                return true;
            }

            int left = high(root.left);
            int right = high(root.right);

            return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int high(TreeNode node) {
            if (node == null) {
                return 0;
            }

            return 1 + Math.max(high(node.left), high(node.right));
        }

        private int recur(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = recur(root.left);
            //如果子结构是非平衡,则其父亲也是非平衡
            if (left == -1) {
                return -1;
            }
            int right = recur(root.right);
            if (right == -1) {
                return -1;
            }

            return Math.abs(right - left) < 2 ? Math.max(left, right) + 1 : -1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
