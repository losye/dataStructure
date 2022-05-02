//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
//
//
// 示例 2：
//
//
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 15
// -100 <= nums[i] <= 100
//
// Related Topics 位运算 数组 哈希表 回溯
// 👍 435 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new IncreasingSubsequences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> res = new ArrayList<>();

        private LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            if (nums == null || nums.length == 0) {
                return res;
            }

            backtrack(nums, 0);

            return res;

        }

        private void backtrack(int[] nums, int index) {
            Set<Integer> set = new HashSet<>();
            if (path.size() >= 2) {
                int size = path.size();
                if (path.get(size - 1) - path.get(size - 2) < 0) {
                    return;
                }
                res.add(new ArrayList<>(path));
            }


            for (int i = index; i < nums.length; i++) {
                int num = nums[i];
                if (set.contains(num)) {
                    continue;
                }
                set.add(num);
                path.add(num);

                backtrack(nums, i + 1);

                path.removeLast();

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
