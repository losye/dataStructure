import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 初始化
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            Integer cnt = need.getOrDefault(c, 0);
            need.put(c, cnt + 1);
        }
        char[] s2charArray = s2.toCharArray();
        int length = s2charArray.length;
        int left = 0, right = 0;
        int valid = 0;
        // 窗口右边界
        while (right < length) {
            // 往窗口放
            char rv = s2charArray[right++];
            if (need.containsKey(rv)) {
                int rc = window.getOrDefault(rv, 0);
                window.put(rv, ++rc);
                if (rc == need.get(rv)) {
                    valid++;
                }
            }

            // 判断窗口是否收缩
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char lv = s2charArray[left++];
                int lc = window.getOrDefault(lv, 0);
                if (need.containsKey(lv)) {
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
