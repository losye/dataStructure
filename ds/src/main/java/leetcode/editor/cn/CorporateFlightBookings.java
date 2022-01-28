//这里有 n 个航班，它们分别从 1 到 n 进行编号。
//
// 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 fi
//rsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
//
// 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
//
//
//
// 示例 1：
//
//
//输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//输出：[10,55,45,25,25]
//解释：
//航班编号        1   2   3   4   5
//预订记录 1 ：   10  10
//预订记录 2 ：       20  20
//预订记录 3 ：       25  25  25  25
//总座位数：      10  55  45  25  25
//因此，answer = [10,55,45,25,25]
//
//
// 示例 2：
//
//
//输入：bookings = [[1,2,10],[2,2,15]], n = 2
//输出：[10,25]
//解释：
//航班编号        1   2
//预订记录 1 ：   10  10
//预订记录 2 ：       15
//总座位数：      10  25
//因此，answer = [10,25]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2 * 104
// 1 <= bookings.length <= 2 * 104
// bookings[i].length == 3
// 1 <= firsti <= lasti <= n
// 1 <= seatsi <= 104
//
// Related Topics 数组 前缀和
// 👍 302 👎 0


package leetcode.editor.cn;

public class CorporateFlightBookings {
    public static void main(String[] args) {
        Solution solution = new CorporateFlightBookings().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        // 构造差分解法
        Difference df = new Difference(nums);

        for (int[] booking : bookings) {
            // 注意转成数组索引要减一
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            // 对区间 nums[i..j] 增加 val
            df.incr(i, j, val);
        }
        // 返回最终的结果数组
        return df.getNums();
    }


    class Difference{

        private int[] diff;

        //nums:  [8,5,9,6,1]
        //diff:  [8,-3,4,-3,-5]
        public Difference(int[] nums){
            diff = new int[nums.length];
            diff[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i-1];
            }
        }

        public void incr(int lo, int hi, int val){
            diff[lo] += val;
            if (hi + 1 < diff.length) {
                diff[hi + 1] -= val;
            }
        }

        public int[] getNums(){
            int[] nums = new int[diff.length];
            nums[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                nums[i] = nums[i - 1] + diff[i];
            }
            return nums;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
