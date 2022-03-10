//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
// Related Topics 数组 回溯
// 👍 1827 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {

            List<Integer> select = new LinkedList<>();
            boolean[] visited = new boolean[nums.length];

            backtrack(nums, select, visited);

            return res;

        }

        private void backtrack(int[] nums, List<Integer> select, boolean[] visited) {
            if (select.size() == nums.length) {
                res.add(new LinkedList<>(select));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];

                if (visited[i]) { // 这里使用 select.contains(num) 太耗时了
                    continue;
                }

                select.add(num);
                visited[i] = true;

                backtrack(nums, select, visited);

                select.remove(select.size() - 1);
                visited[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
