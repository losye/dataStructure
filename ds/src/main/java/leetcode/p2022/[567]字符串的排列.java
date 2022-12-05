import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            int val = need.getOrDefault(c, 0);
            need.put(c, val + 1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        char[] chars = s2.toCharArray();
        int left = 0; int right = 0; int valid = 0;
        while (right < chars.length) {
            char rv = chars[right++];
            if (need.containsKey(rv)) {
                int rc = window.getOrDefault(rv, 0);
                window.put(rv, ++rc);
                if (need.get(rv) == rc) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char lv = chars[left++];
                if (need.containsKey(lv)) {
                    int lc = window.get(lv);
                    if (need.get(lv) == lc) {
                        valid--;
                    }
                    window.put(lv, lc - 1);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
