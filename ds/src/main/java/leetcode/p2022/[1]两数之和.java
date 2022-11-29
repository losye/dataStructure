import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valIdxMap = new HashMap<>();
        int[] res = new int[]{0, 0};
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (valIdxMap.containsKey(target - num)) {
               return new int[]{i, valIdxMap.get(target - num)};
            }
            valIdxMap.put(num, i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
