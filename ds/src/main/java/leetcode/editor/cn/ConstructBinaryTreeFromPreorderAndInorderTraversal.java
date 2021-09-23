//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。
//
//
//
// 示例 1:
//
//
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
//
//
// 示例 2:
//
//
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
//
//
//
//
// 提示:
//
//
// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder 和 inorder 均无重复元素
// inorder 均出现在 preorder
// preorder 保证为二叉树的前序遍历序列
// inorder 保证为二叉树的中序遍历序列
//
// Related Topics 树 数组 哈希表 分治 二叉树
// 👍 1203 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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

        private Map<Integer, Integer> indexMap;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            // 构造哈希映射，帮助我们快速定位根节点
            indexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }

            return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
        }

        private TreeNode build(int[] preorder, int pleft, int pright,
                               int[] inorder, int ileft, int iright) {

            if (pleft >= pright) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[pleft]);

            // 在中序遍历中定位根节点
            int i_root_index = indexMap.get(preorder[pleft]);
            int leftNum = i_root_index - ileft;

            root.left = build(preorder, pleft + 1, leftNum + pleft + 1,
                    inorder, ileft, i_root_index - 1);
            root.right = build(preorder, leftNum + pleft + 1, pright,
                    inorder, i_root_index + 1, iright);

            return root;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
