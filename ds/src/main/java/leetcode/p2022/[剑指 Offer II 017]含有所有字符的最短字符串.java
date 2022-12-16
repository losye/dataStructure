import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            Integer val = need.getOrDefault(c, 0);
            need.put(c, val + 1);
        }
        char[] chars = s.toCharArray();
        int left = 0; int right = 0; int valid = 0;
        int len = Integer.MAX_VALUE; int start = 0;
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

            while (valid == need.size()) {
                if (len > right - left) {
                    len = right - left;
                    start = left;
                }
                char lv = chars[left];
                left++;
                if (need.containsKey(lv)) {
                    int lc = window.get(lv);
                    window.put(lv, lc - 1);
                    if (lc == need.get(lv)) {
                        valid--;
                    }
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
