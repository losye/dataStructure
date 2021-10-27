//给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
//
//
//
// 示例 1：
//
//
//输入: root = [8,6,10,5,7,9,11], k = 12
//输出: true
//解释: 节点 5 和节点 7 之和等于 12
//
//
// 示例 2：
//
//
//输入: root = [8,6,10,5,7,9,11], k = 22
//输出: false
//解释: 不存在两个节点值之和为 22 的节点
//
//
//
//
// 提示：
//
//
// 二叉树的节点个数的范围是 [1, 104].
// -104 <= Node.val <= 104
// root 为二叉搜索树
// -105 <= k <= 105
//
//
//
//
// 注意：本题与主站 653 题相同： https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树
// 👍 4 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class OpLdQZ {
    public static void main(String[] args) {
        Solution solution = new OpLdQZ().new Solution();
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
    List<Integer> arr =  new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        inorder(root);

        int start = 0;
        int end = arr.size() -1;

        while (start < end) {
            Integer startVal = arr.get(start);
            Integer endVal = arr.get(end);
            int sum = startVal + endVal;
            if ( sum == k) {
                return true;
            } else if (sum < k) {
                start++;
            } else {
                end--;
            }

        }
        return false;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        arr.add(root.val);

        inorder(root.right);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
