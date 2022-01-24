//给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,1], k = 2
//输出：2
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3], k = 3
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107
//
// Related Topics 数组 哈希表 前缀和
// 👍 1280 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 前缀和 -> 该前缀和出现的次数
        private HashMap<Integer, Integer> preSum = new HashMap<>();


        public int subarraySum(int[] nums, int k) {
            preSum.put(0, 1);

            int res = 0, sumI = 0;

            for (int i = 0; i < nums.length; i++) {
                sumI += nums[i];

                if (preSum.containsKey(sumI - k)) {
                    res += preSum.get(sumI - k);
                }


                preSum.put(sumI, preSum.getOrDefault(sumI, 0) + 1);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
