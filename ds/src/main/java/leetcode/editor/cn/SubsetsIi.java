//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
//
//
//
// Related Topics 位运算 数组 回溯
// 👍 801 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> res = new ArrayList<>();

        private LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums == null || nums.length == 0) {
                return res;
            }

            Arrays.sort(nums);
            backtrack(nums, 0);

            return res;
        }

        private void backtrack(int[] nums, int index) {
            res.add(new ArrayList<>(path));
            //             [ ]
            //      1       2      2(x)
            //    2  2(x)   2
            //   2
            for (int i = index; i < nums.length; i++) {
                int num = nums[i];
                if (i > index && nums[i - 1] == nums[i]) {
                    continue;
                }

                path.add(num);

                backtrack(nums, i + 1);

                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
