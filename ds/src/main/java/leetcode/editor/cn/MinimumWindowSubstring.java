//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
//
//
// 注意：
//
//
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。
//
//
//
//
// 示例 1：
//
//
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//
//
// 示例 2：
//
//
//输入：s = "a", t = "a"
//输出："a"
//
//
// 示例 3:
//
//
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 105
// s 和 t 由英文字母组成
//
//
//
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口
// 👍 1690 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.equals("")) {
            return "";
        }
        // 两个hash表可以用数组替代
        // int[] need = new int[128];
        // int[] have = window int[128];
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int start = 0; int left = 0; int right = 0;
        int valid = 0; int len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char add = s.charAt(right);
            right++;

            window.put(add, window.getOrDefault(add, 0) + 1);

            if (need.getOrDefault(add, 0).equals(window.get(add))) {
                valid++;
            }

            System.out.printf("window: [%d, %d)\n", left, right);

            while (valid == need.size()) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }

                char remove = s.charAt(left);
                left++;
                Integer rmCnt = window.getOrDefault(remove, 0);
                window.put(remove, rmCnt - 1);
                if (need.containsKey(remove)) {
                    if (need.get(remove).equals(rmCnt)) {
                        valid--;
                    }
                }
            }
        }

        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, start + len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
