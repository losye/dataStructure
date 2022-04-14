//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Related Topics 数组 回溯
// 👍 1021 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> res = new ArrayList<>();

        private LinkedList<Integer> path = new LinkedList<>();

        private boolean[] visited;

        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums == null || nums.length == 0) {
                return res;
            }
            Arrays.sort(nums);
            visited = new boolean[nums.length];
            backtrack(nums);

            return res;

        }

        private void backtrack(int[] nums) {
            if (nums.length == path.size()) {
                res.add(new ArrayList<>(path));
                return;
            }
            int preNum = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                int num = nums[i];
                if (num == preNum) {
                    continue;
                }
                preNum = num;
                visited[i] = true;
                path.add(num);

                backtrack(nums);

                visited[i] = false;
                path.removeLast();

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
