//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
//
//
//
// 示例：
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
//
//
//
//
// 提示：
//
//
// 树中至少有 2 个节点。
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
//相同
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树
// 👍 275 👎 0


package leetcode.editor.cn;

public class MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
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

    private int minDiff = Integer.MAX_VALUE;

    private int base = -1;

    public int getMinimumDifference(TreeNode root) {

        inorder(root);

        return minDiff;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        choose(root);

        inorder(root.right);

    }

    private void choose(TreeNode root) {
        int val = root.val;


        if (base == -1) {
            base = val;
        } else {
            int diff = Math.abs(val - base);
            minDiff = Math.min(diff, minDiff);
            base = val;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
