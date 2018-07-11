package leetcode.tree;

/**
 * ${DESCRIPTION}
 *
 * @author zhangzhengye
 * @create 2017-11-12 下午5:38
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from
 * the root node down to the farthest leaf node.
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
