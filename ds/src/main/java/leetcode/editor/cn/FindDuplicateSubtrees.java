//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。
//
// 示例 1：
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
//
//
// 下面是两个重复的子树：
//
//       2
//     /
//    4
//
//
// 和
//
//     4
//
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树
// 👍 331 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    public static void main(String[] args) {
        Solution solution = new FindDuplicateSubtrees().new Solution();
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
    private HashMap<String, Integer> treeCountMap = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        dfs(root);

        return result;
    }



    private String dfs(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String treeKey = root.val + "," + dfs(root.left) + "," + dfs(root.right);
        treeCountMap.put(treeKey, treeCountMap.getOrDefault(treeKey, 0) +1);

        if (treeCountMap.get(treeKey) == 2) {
            result.add(root);
        }

        return treeKey;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
