//给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//输出：15
//
//
// 示例 2：
//
//
//输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：19
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [1, 104] 之间。
// 1 <= Node.val <= 100
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树
// 👍 72 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class DeepestLeavesSum {
    public static void main(String[] args) {
        Solution solution = new DeepestLeavesSum().new Solution();
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

    private int max = 0;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return max;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                levelSum += node.val;

                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            max = levelSum;
        }

        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
