import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        char[] chars = s.toCharArray();
        int left = 0; int right = 0; int res = 0;

        while (right < chars.length) {
            char rv = chars[right++];
            int rc = window.getOrDefault(rv, 0);
            window.put(rv, rc + 1);

            while (window.get(rv) > 1) {
                char lv = chars[left++];
                int lc = window.getOrDefault(lv, 0);
                window.put(lv, lc - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
