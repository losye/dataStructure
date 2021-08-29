//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
//
//
//
// 示例：
//
//
//输入：[1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
//
//
//
//
// 提示：
//
//
// 1 <= k <= n <= 30,000。
// 所给数据范围 [-10,000，10,000]。
//
// Related Topics 数组 滑动窗口
// 👍 201 👎 0


package leetcode.editor.cn;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        Solution solution = new MaximumAverageSubarrayI().new Solution();
        solution.findMaxAverage(new int[]{-1}, 1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result = -10_001;
        int left = 0;
        int right = 0;
        double temp = 0;
        while (right < nums.length) {

            int r = nums[right];
            right++;
            temp += r;

            while (right - left >= k) {
                result = Math.max(result, temp / k);

                int l = nums[left];
                temp -= l;
                left++;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
