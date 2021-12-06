//给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
//
//
// （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
//输出：7
//解释：
//我们有大量的节点与其祖先的差值，其中一些如下：
//|8 - 3| = 5
//|3 - 7| = 4
//|8 - 1| = 7
//|10 - 13| = 3
//在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
//
//
// 示例 2：
//
//
//输入：root = [1,null,2,null,0,3]
//输出：3
//
//
//
//
// 提示：
//
//
// 树中的节点数在 2 到 5000 之间。
// 0 <= Node.val <= 105
//
// Related Topics 树 深度优先搜索 二叉树
// 👍 103 👎 0


package leetcode.editor.cn;

public class MaximumDifferenceBetweenNodeAndAncestor {
    public static void main(String[] args) {
        Solution solution = new MaximumDifferenceBetweenNodeAndAncestor().new Solution();
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

    private int result = 0;

    //不能用全局最大值最小值,因为左子树的最大/小值,不能用在右子树中(不是共同祖先)
    //private int max
    //private int min

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return result;
        }

        dfs(root, root.val, root.val);
        return result;

    }

    private void dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }

        int maxDiff = Math.abs(root.val - max);
        int minDiff = Math.abs(root.val - min);
        result = Math.max(result, Math.max(maxDiff, minDiff));
        max = Math.max(root.val, max);
        min = Math.min(root.val, min);

        dfs(root.left, min, max);

        dfs(root.right, min, max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
