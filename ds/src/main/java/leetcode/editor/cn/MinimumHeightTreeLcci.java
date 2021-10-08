//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。示例: 给定有序数组: [-10,-3,0,5,9], 一个可能
//的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：           0          / \        -3
//  9        /   /      -10  5 Related Topics 树 二叉搜索树 数组 分治 二叉树
// 👍 100 👎 0


package leetcode.editor.cn;

public class MinimumHeightTreeLcci {
    public static void main(String[] args) {
        Solution solution = new MinimumHeightTreeLcci().new Solution();
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1) {
            return null;
        }
        int start = 0;
        int end = nums.length - 1;
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = build(nums, start, middle);
        root.right = build(nums, middle, end);

        return root;
    }

    private TreeNode build(int[] nums, int start, int end) {
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
