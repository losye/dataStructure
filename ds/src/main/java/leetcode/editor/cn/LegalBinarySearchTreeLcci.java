//实现一个函数，检查一棵二叉树是否为二叉搜索树。示例 1: 输入:     2    / \   1   3 输出: true 示例 2: 输入:     5
//    / \   1   4      / \     3   6 输出: false 解释: 输入为: [5,1,4,null,null,3,6]。  
//  根节点的值为 5 ，但是其右子节点值为 4 。 Related Topics 树 深度优先搜索 二叉搜索树 二叉树
// 👍 67 👎 0


package leetcode.editor.cn;

public class LegalBinarySearchTreeLcci {
    public static void main(String[] args) {
        Solution solution = new LegalBinarySearchTreeLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null) {
            return true;
        }

        boolean left = isValid(root.left, root, min);
        boolean right = isValid(root.right, max, root);

        boolean self = (max == null || root.val < max.val) &&
                (min == null || root.val > min.val);

        return left && right && self;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
