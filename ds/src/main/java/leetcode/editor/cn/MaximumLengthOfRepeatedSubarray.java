//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
//
//
//
// 示例：
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
//
//
//
//
// 提示：
//
//
// 1 <= len(A), len(B) <= 1000
// 0 <= A[i], B[i] < 100
//
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希
// 👍 525 👎 0


package leetcode.editor.cn;

public class MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfRepeatedSubarray().new Solution();
        int length = solution.findLength(new int[]{0, 0, 0, 0, 1},
                new int[]{1, 0, 0, 0, 0});
        System.out.println(length);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         *
         * 1 2 3 2 1 x x x    len:m
         *     3 2 1 4 7      len:n  i = 2
         *
         *     1 2 3 2 1
         * 3 2 1 4 7 x x x
         */
        public int findLength(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int res = 0;
            for (int i = 0; i < m; i++) {
                //固定窗口大小
                int len = Math.min(n, m-i);
                int max = maxLen(nums1, nums2, i, 0, len);
                res = Math.max(res, max);

            }

            for (int i = 0; i < n; i++) {
                //固定窗口大小
                int len = Math.min(m, n-i);
                int max = maxLen(nums1, nums2, 0, i, len);
                res = Math.max(res, max);
            }

            return res;
            // return dp(nums1, nums2);
        }


        private int maxLen(int[] nums1, int[] nums2, int index1, int index2, int len) {
            int max = 0;
            int temp = 0;
            for (int i = 0; i < len; i++) {
                if (nums1[index1 + i] == nums2[index2 + i]) {
                    temp++;
                } else {
                    temp = 0;
                }
                max = Math.max(max, temp);
            }
            return max;
        }


        /**
         * * * 1 2 3 2 1
         * *
         * 3   0 0 1 0 0
         * 2   0 1 0 2 0
         * 1   1 0 0 0 3
         * 4   0
         * 7   0
         */
        private int dp(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int res = 0;
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }

                    res = Math.max(dp[i][j], res);
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
