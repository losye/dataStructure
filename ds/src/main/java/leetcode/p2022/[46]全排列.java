import java.util.ArrayList;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        backtrack(nums, new LinkedList<>());

        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> path){
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }
            path.add(num);
            backtrack(nums, path);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
