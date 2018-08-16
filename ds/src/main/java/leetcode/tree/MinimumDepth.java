package leetcode.tree;

/**
 * ${DESCRIPTION}
 *
 * @author zhangzhengye
 * @create 2017-11-09 下午11:05
 * <p>
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along
 * <p>
 * the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepth {

    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null) {
            return run(root.left) + 1;
        }
        if (root.left == null) {
            return run(root.right) + 1;
        }
        return Math.min(run(root.left), run(root.right)) + 1;
    }
}
