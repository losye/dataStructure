//给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
//
//
// 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
//
//
// 如果不存在祖父节点值为偶数的节点，那么返回 0 。
//
//
//
// 示例：
//
//
//
// 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：18
//解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
//
//
//
//
// 提示：
//
//
// 树中节点的数目在 1 到 10^4 之间。
// 每个节点的值在 1 到 100 之间。
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树
// 👍 66 👎 0


package leetcode.editor.cn;

public class SumOfNodesWithEvenValuedGrandparent {
    public static void main(String[] args) {
        Solution solution = new SumOfNodesWithEvenValuedGrandparent().new Solution();
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

    private int res;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);

        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (root.val % 2 == 0) {
            addVal(left);
            addVal(right);
        }


        dfs(left);
        dfs(right);
    }

    private void addVal(TreeNode node) {
        if (node != null) {
            if (node.left != null) {
                res += node.left.val;
            }
            if (node.right != null) {
                res += node.right.val;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
