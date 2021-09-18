//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回锯齿形层序遍历如下：
//
//
//[
//  [3],
//  [20,9],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索 二叉树
// 👍 518 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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

    List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        order(root, true, 0);

        return result;
    }

    private void order(TreeNode root, boolean order, int level) {
        if (root == null) {
            return;
        }
        if (result.size() <= level) {
            List<Integer> levelList =  new LinkedList<>();
            result.add(levelList);
        }
        LinkedList<Integer> levelList = (LinkedList)result.get(level);
        int val = root.val;
        if (order) {
            levelList.addLast(val);
        } else {
            levelList.addFirst(val);
        }



        order(root.left, !order, level + 1);
        order(root.right, !order,level + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
