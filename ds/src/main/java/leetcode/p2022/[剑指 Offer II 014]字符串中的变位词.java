import java.util.HashMap;
import java.util.function.BiFunction;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            Integer val = need.getOrDefault(c, 0);
            need.put(c, val + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        char[] chars = s2.toCharArray();
        while (right < chars.length) {
            char rv = chars[right];
            right++;
            if (need.containsKey(rv)) {
                int rc = window.getOrDefault(rv, 0);
                window.put(rv, rc + 1);
                if (rc + 1 == need.get(rv)) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char lv = chars[left];
                left++;
                if (need.containsKey(lv)) {
                    int lc = window.getOrDefault(lv, 0);
                    window.put(lv, lc - 1);
                    if (lc == need.get(lv)) {
                        valid--;
                    }
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
