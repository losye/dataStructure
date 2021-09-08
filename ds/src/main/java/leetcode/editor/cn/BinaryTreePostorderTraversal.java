//给定一个二叉树，返回它的 后序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 深度优先搜索 二叉树
// 👍 666 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
               return result;
            }
            Stack<TreeNode> stack_1 = new Stack<>();
            Stack<TreeNode> stack_2 = new Stack<>();
            stack_1.push(root);
            while (!stack_1.isEmpty()) {
                TreeNode pop = stack_1.pop();
                stack_2.push(pop);

                if (pop.left != null) {
                    stack_1.push(pop.left);
                }
                if (pop.right != null) {
                    stack_1.push(pop.right);
                }
            }

            while (!stack_2.isEmpty()) {
                TreeNode pop = stack_2.pop();
                result.add(pop.val);
            }


            //postorder(root, result);
            return result;

        }

        private void postorder(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }

            postorder(root.left, result);
            postorder(root.right, result);

            result.add(root.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
