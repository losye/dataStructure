//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。
//
// 一般来说，删除节点可分为两个步骤：
//
//
// 首先找到需要删除的节点；
// 如果找到了，删除它。
//
//
//
//
// 示例 1:
//
//
//
//
//输入：root = [5,3,6,2,4,null,7], key = 3
//输出：[5,4,6,2,null,null,7]
//解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
//
//
// 示例 2:
//
//
//输入: root = [5,3,6,2,4,null,7], key = 0
//输出: [5,3,6,2,4,null,7]
//解释: 二叉树不包含值为 0 的节点
//
//
// 示例 3:
//
//
//输入: root = [], key = 0
//输出: []
//
//
//
// 提示:
//
//
// 节点数的范围 [0, 104].
// -105 <= Node.val <= 105
// 节点值唯一
// root 是合法的二叉搜索树
// -105 <= key <= 105
//
//
//
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
// Related Topics 树 二叉搜索树 二叉树
// 👍 561 👎 0


package leetcode.editor.cn;

public class DeleteNodeInABst {
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInABst().new Solution();
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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);
            } else {
                // 找到等于key的节点
                if (root.left == null && root.right == null) {
                    //左右子树为空,直接删除
                    root = null;
                } else if (root.right != null) {
                    // 后继节点
                    root.val = successor(root);
                    root.right = deleteNode(root.right, root.val);
                } else {
                    // 前序节点
                    root.val = predecessor(root);
                    root.left = deleteNode(root.left, root.val);
                }
            }

            return root;
        }


        public int successor(TreeNode root) {
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
            return root.val;
        }

        public int predecessor(TreeNode root) {
            root = root.left;
            while (root.right != null) {
                root = root.right;
            }
            return root.val;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
