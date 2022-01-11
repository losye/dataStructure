//给你 root1 和 root2 这两棵二叉搜索树。
//
// 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
//
//
//
// 示例 1：
//
//
//
// 输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
//
//
// 示例 2：
//
// 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
//输出：[-10,0,0,1,2,5,7,10]
//
//
// 示例 3：
//
// 输入：root1 = [], root2 = [5,1,7,0,2]
//输出：[0,1,2,5,7]
//
//
// 示例 4：
//
// 输入：root1 = [0,-10,10], root2 = []
//输出：[-10,0,10]
//
//
// 示例 5：
//
//
//
// 输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
//
//
//
//
// 提示：
//
//
// 每棵树最多有 5000 个节点。
// 每个节点的值在 [-10^5, 10^5] 之间。
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 排序
// 👍 73 👎 0


package leetcode.editor.cn;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AllElementsInTwoBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new AllElementsInTwoBinarySearchTrees().new Solution();
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
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            BSTIterator bstIterator1 = new BSTIterator(root1);
            BSTIterator bstIterator2 = new BSTIterator(root2);
            List<Integer> res = new LinkedList<>();

            while (bstIterator1.hasNext() && bstIterator2.hasNext()) {
                TreeNode peek1 = bstIterator1.peek();
                TreeNode peek2 = bstIterator2.peek();
                if (peek1.val > peek2.val) {
                    res.add(bstIterator2.next().val);
                } else {
                    res.add(bstIterator1.next().val);
                }
            }

            while (bstIterator1.hasNext()) {
                res.add(bstIterator1.next().val);
            }

            while (bstIterator2.hasNext()) {
                res.add(bstIterator2.next().val);
            }

            return res;
        }


        class BSTIterator implements Iterator<TreeNode> {

            private Stack<TreeNode> stack = new Stack<>();

            public BSTIterator(TreeNode root) {
                pushLeft(root);
            }

            private void pushLeft(TreeNode node) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

            public TreeNode peek(){
                return stack.peek();
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public TreeNode next() {
                TreeNode pop = stack.pop();
                pushLeft(pop.right);
                return pop;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
