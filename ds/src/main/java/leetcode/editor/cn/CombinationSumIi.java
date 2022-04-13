//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用 一次 。
//
// 注意：解集不能包含重复的组合。
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
// Related Topics 数组 回溯
// 👍 917 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> res = new ArrayList<>();

        private LinkedList<Integer> path = new LinkedList<>();

        private int curSum = 0;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if (candidates == null || candidates.length == 0) {
                return res;
            }
            Arrays.sort(candidates);

            backtrack(candidates, 0, target);

            return res;
        }

        private void backtrack(int[] candidates, int index, int target) {
            if (curSum == target) {
                res.add(new ArrayList<>(path));
                return;
            }
            if (curSum > target) {
                return;
            }

            for (int i = index; i < candidates.length; i++) {
                int candidate = candidates[i];
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                curSum += candidate;
                path.add(candidate);

                backtrack(candidates, i + 1, target);

                curSum -= candidate;
                path.removeLast();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
