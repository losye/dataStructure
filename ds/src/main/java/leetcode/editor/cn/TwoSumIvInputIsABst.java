//给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
//
//
//
// 示例 1：
//
//
//输入: root = [5,3,6,2,4,null,7], k = 9
//输出: true
//
//
// 示例 2：
//
//
//输入: root = [5,3,6,2,4,null,7], k = 28
//输出: false
//
//
// 示例 3：
//
//
//输入: root = [2,1,3], k = 4
//输出: true
//
//
// 示例 4：
//
//
//输入: root = [2,1,3], k = 1
//输出: false
//
//
// 示例 5：
//
//
//输入: root = [2,1,3], k = 3
//输出: true
//
//
//
//
// 提示:
//
//
// 二叉树的节点个数的范围是 [1, 104].
// -104 <= Node.val <= 104
// root 为二叉搜索树
// -105 <= k <= 105
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树
// 👍 282 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIvInputIsABst {
    public static void main(String[] args) {
        Solution solution = new TwoSumIvInputIsABst().new Solution();
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

    private List<Integer> inorder = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {

        order(root);

        int start = 0;
        int end = inorder.size() - 1;

        while (start < end) {
            Integer startVal = inorder.get(start);
            Integer endVal = inorder.get(end);
            int sum = startVal + endVal;
            if (sum == k) {
                return true;
            } else if (sum > k) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }

    private void order(TreeNode root) {
        if (root == null) {
            return;
        }
        order(root.left);
        inorder.add(root.val);
        order(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
