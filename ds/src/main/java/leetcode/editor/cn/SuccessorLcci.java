//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
//
// 如果指定节点没有对应的“下一个”节点，则返回null。
//
// 示例 1:
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2
//
// 示例 2:
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /
//1
//
//输出: null
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树
// 👍 85 👎 0


package leetcode.editor.cn;

public class SuccessorLcci {
    public static void main(String[] args) {
        Solution solution = new SuccessorLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        private TreeNode res;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

            inorder(root, p);
            return res;

        }

        private void inorder(TreeNode root, TreeNode p) {
            if (root == null) {
                return;
            }

            if (res != null) {
                //剪枝
                return;
            }


            inorder(root.left, p);

            if (res == null && root.val > p.val) {
                res = root;
                return;
            }

            inorder(root.right, p);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
