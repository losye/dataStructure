//计算给定二叉树的所有左叶子之和。
//
// 示例：
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树
// 👍 343 👎 0


package leetcode.editor.cn;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;


    public int sumOfLeftLeaves(TreeNode root) {

        sum(root);
        return sum;
    }

    private void sum(TreeNode root) {
        if (root == null) {
            return ;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            if (left.left == null && left.right == null) {
                sum += left.val;
            }
        }

        sum(left);
        sum(right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
