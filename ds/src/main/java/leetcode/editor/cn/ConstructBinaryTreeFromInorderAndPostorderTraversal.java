//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics 树 数组 哈希表 分治 二叉树
// 👍 581 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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


        private Map<Integer, Integer> indexMap = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++) {
                indexMap.put(inorder[i], i);
            }


            return build(inorder, 0, inorder.length - 1,
                    postorder, 0, postorder.length - 1);
        }

        private TreeNode build(int[] inorder, int istart, int iend,
                               int[] postorder, int pstart, int pend) {
            if (istart > iend || pstart > pend) {
                return null;
            }


            int rootVal = postorder[pend];

            Integer index = indexMap.get(rootVal);
            TreeNode root = new TreeNode(postorder[pend]);


            root.left = build(inorder, istart, index - 1,
                    postorder, pstart, pend - iend + index - 1);
            root.right = build(inorder, index + 1, iend,
                    postorder, pend - iend + index, pend - 1);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
