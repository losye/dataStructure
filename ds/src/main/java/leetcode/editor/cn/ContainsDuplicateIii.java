//给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <=
//t ，同时又满足 abs(i - j) <= k 。
//
// 如果存在则返回 true，不存在返回 false。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,1], k = 3, t = 0
//输出：true
//
// 示例 2：
//
//
//输入：nums = [1,0,1,1], k = 1, t = 2
//输出：true
//
// 示例 3：
//
//
//输入：nums = [1,5,9,1,5,9], k = 2, t = 3
//输出：false
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 2 * 104
// -231 <= nums[i] <= 231 - 1
// 0 <= k <= 104
// 0 <= t <= 231 - 1
//
// Related Topics 数组 桶排序 有序集合 排序 滑动窗口
// 👍 492 👎 0


package leetcode.editor.cn;

import java.util.TreeSet;

public class ContainsDuplicateIii {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // fuck 测试用例
        TreeSet<Long> window = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            Long floor = window.floor(num);
            Long ceiling = window.ceiling(num);
            if (floor != null) {
                if (Math.abs(floor - num) <= t) {
                    return true;
                }
            }
            if (ceiling != null) {
                if (Math.abs(ceiling - num) <= t) {
                    return true;
                }
            }

            window.add(num);

            if (i >= k) {
                window.remove((long) nums[i - k]);
            }

        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
