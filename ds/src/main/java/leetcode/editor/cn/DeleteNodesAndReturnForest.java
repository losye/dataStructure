//给出二叉树的根节点 root，树上每个节点都有一个不同的值。
//
// 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
//
// 返回森林中的每棵树。你可以按任意顺序组织答案。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
//输出：[[1,2,null,4],[6],[7]]
//
//
// 示例 2：
//
//
//输入：root = [1,2,4,null,3], to_delete = [3]
//输出：[[1,2,4]]
//
//
//
//
// 提示：
//
//
// 树中的节点数最大为 1000。
// 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
// to_delete.length <= 1000
// to_delete 包含一些从 1 到 1000、各不相同的值。
//
// Related Topics 树 深度优先搜索 二叉树
// 👍 151 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        Solution solution = new DeleteNodesAndReturnForest().new Solution();
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

    private List<TreeNode> result = new ArrayList<>();

    private boolean[] isDeleted = new boolean[1001];


    //       4
    //    2     1
    //  5  3  9
    //
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        for (int delete : to_delete) {
            isDeleted[delete] = true;
        }

        dfs(root, true);

        return result;

    }

    private TreeNode dfs(TreeNode root, boolean isRoot) {
        if (root == null) {
            return null;
        }
        boolean delete = isDeleted[root.val];

        if (!delete && isRoot) {
            result.add(root);
        }
        //如果delete则左和右都为root
        root.left = dfs(root.left, delete);
        root.right = dfs(root.right, delete);

        return delete ? null : root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
