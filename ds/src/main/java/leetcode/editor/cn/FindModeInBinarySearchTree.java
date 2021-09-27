//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
//
// 假定 BST 有如下定义：
//
//
// 结点左子树中所含结点的值小于等于当前结点的值
// 结点右子树中所含结点的值大于等于当前结点的值
// 左子树和右子树都是二叉搜索树
//
//
// 例如：
//给定 BST [1,null,2,2],
//
//    1
//    \
//     2
//    /
//   2
//
//
// 返回[2].
//
// 提示：如果众数超过1个，不需考虑输出顺序
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树
// 👍 352 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
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
    List<Integer> answer = new ArrayList<>();
    int base, count, maxCount;

    public int[] findMode(TreeNode root) {

        inorder(root);

        int[] res = new int[answer.size()];

        for (int i = 0; i < answer.size(); ++i) {
            res[i] = answer.get(i);
        }
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        update(root);

        inorder(root.right);
    }

    private void update(TreeNode root) {
        int val = root.val;
        if (base == val) {
            count++;
        } else {
            count = 1;
            base = val;
        }
        if (count == maxCount) {
            answer.add(val);
        }

        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(val);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
