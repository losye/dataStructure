//满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
//
// 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
//
// 答案中每个树的每个结点都必须有 node.val=0。
//
// 你可以按任何顺序返回树的最终列表。
//
//
//
// 示例：
//
// 输入：7
//输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0
//,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
//解释：
//
//
//
//
//
// 提示：
//
//
// 1 <= N <= 20
//
// Related Topics 树 递归 记忆化搜索 动态规划 二叉树
// 👍 237 👎 0


package leetcode.editor.cn;

import java.util.List;

public class AllPossibleFullBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new AllPossibleFullBinaryTrees().new Solution();
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
    public List<TreeNode> allPossibleFBT(int n) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
