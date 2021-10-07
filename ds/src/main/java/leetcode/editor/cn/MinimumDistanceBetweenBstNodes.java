//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//
// 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bs
//t/ 相同
//
//
//
//
//
// 示例 1：
//
//
//输入：root = [4,2,6,1,3]
//输出：1
//
//
// 示例 2：
//
//
//输入：root = [1,0,48,null,null,12,49]
//输出：1
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [2, 100] 内
// 0 <= Node.val <= 105
// 差值是一个正数，其数值等于两值之差的绝对值
//
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树
// 👍 201 👎 0


package leetcode.editor.cn;

public class MinimumDistanceBetweenBstNodes {
    public static void main(String[] args) {
        Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int prev = -1;

    private int result = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {


        searchBST(root);


        return result;
    }

    private void searchBST(TreeNode root) {
        if (root == null) {
            return;
        }

        searchBST(root.left);

        if (prev == -1) {
            prev = root.val;
        } else {
            result = Math.min(result, Math.abs(prev - root.val));
            prev = root.val;
        }


        searchBST(root.right);


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
