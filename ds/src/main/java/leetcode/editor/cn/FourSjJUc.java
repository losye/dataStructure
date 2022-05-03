//给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
//。
//
// candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
//
//
//
// 示例 1:
//
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//
// 示例 2:
//
//
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//]
//
//
//
// 提示:
//
//
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
//
//
//
//
// 注意：本题与主站 40 题相同： https://leetcode-cn.com/problems/combination-sum-ii/
// Related Topics 数组 回溯
// 👍 20 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSjJUc {
    public static void main(String[] args) {
        Solution solution = new FourSjJUc().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> res = new ArrayList<>();

        private LinkedList<Integer> path = new LinkedList<>();

        private int sum = 0;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if (candidates.length == 0) {
                return res;
            }
            Arrays.sort(candidates);

            backtrack(candidates, target, 0);

            return res;
        }

        // [10,1,2,7,6,1,5]
        // [1,1,2,5,6,7,10]
        private void backtrack(int[] candidates, int target, int index) {
            if (sum > target) {
                return;
            }

            if (sum == target) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                int candidate = candidates[i];

                sum += candidate;
                path.add(candidate);

                backtrack(candidates, target, i + 1);

                sum -= candidate;
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
