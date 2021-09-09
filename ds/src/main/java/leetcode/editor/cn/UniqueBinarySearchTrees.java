//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：5
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= n <= 19
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树
// 👍 1300 👎 0


package leetcode.editor.cn;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 1 2 3
         * <p>
         *
         *  1 2
         *
         *   1      2
         *    2   1
         *
         *   1       1         2         3     3
         *    2        3     1   3     2     1
         *      3    2               1         2
         *
         * <p>
         *
         * 遍历每个数字 i，将该数字作为树根，将 (i−1) 序列作为左子树，将 (i+1) 序列作为右子树
         *
         *  g(n) 表示 1~n 二叉搜索树结果数量
         *  f(n) 表示以 n 为 root的bts数量
         *
         *  g(n) = f(1) + f(2) + f(i) ... + f(n)
         *
         *  当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i
         *  f(i) = g(i-1) * g(n-i)
         *
         *  则G(n) = G(1 - 1) * G(n - 1) + G(2 - 1) * G(n - 2) + ... + G(n - 1) * G(n - n)
         *
         *  初始条件：G(0) = 1, G(1) = 1
         *
         *
         *
         */

        public int numTrees(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i < n + 1; i++){
                for (int j = 1; j < i + 1; j++) {
                    dp[i] += dp[j-1] * dp[i-j];
                }
            }

            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
