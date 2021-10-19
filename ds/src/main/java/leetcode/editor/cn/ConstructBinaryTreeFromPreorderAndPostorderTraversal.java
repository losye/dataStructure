//返回与给定的前序和后序遍历匹配的任何二叉树。
//
// pre 和 post 遍历中的值是不同的正整数。
//
//
//
// 示例：
//
// 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
//
//
//
//
// 提示：
//
//
// 1 <= pre.length == post.length <= 30
// pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
// 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
//
// Related Topics 树 数组 哈希表 分治 二叉树
// 👍 192 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
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

        private Map<Integer, Integer> memo = new HashMap<>();

        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            for (int i = 0; i < postorder.length; i++) {
                memo.put(postorder[i], i);
            }

            return build(preorder, 0, preorder.length - 1,
                    postorder, 0, postorder.length - 1);
        }

        private TreeNode build(int[] preorder, int preStrart, int preEnd,
                               int[] postorder, int postStart, int postEnd) {

            if (preStrart > preEnd || postStart > postEnd) {
                return null;
            }

            if (preStrart == preEnd) {
                return new TreeNode(preorder[preStrart]);
            }

            int rootVal = preorder[preStrart];
            TreeNode root = new TreeNode(rootVal);

            int next = preorder[preStrart + 1];
            Integer indexRoot = memo.get(next);

            int leftLen = indexRoot - postStart + 1;


            root.left = build(preorder, preStrart + 1, preStrart + leftLen,
                    postorder, postStart, postStart + leftLen - 1);

            root.right = build(preorder, preStrart + leftLen + 1, preEnd,
                    postorder, postStart + leftLen, postEnd - 1);


            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
