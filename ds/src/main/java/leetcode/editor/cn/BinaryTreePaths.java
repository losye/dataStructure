//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
// 叶子节点 是指没有子节点的节点。
//
//
// 示例 1：
//
//
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
//
//
// 示例 2：
//
//
//输入：root = [1]
//输出：["1"]
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [1, 100] 内
// -100 <= Node.val <= 100
//
// Related Topics 树 深度优先搜索 字符串 二叉树
// 👍 584 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
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

    private List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return paths;
    }

    private void dfs(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            paths.add(path + root.val);
            return;
        }
        path += root.val + "->";
        dfs(root.left, path);
        dfs(root.right, path);
        path = path.substring(0, path.length()-1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
