//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 字符串 滑动窗口
// 👍 5982 👎 0
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> window = new HashMap<>();
        int start,end,res;
        start = end = res = 0;
        char[] sources = s.toCharArray();


        while (end < s.length()) {
            char add = sources[end];
            end++;
            Integer cnt = window.getOrDefault(add, 0);
            window.put(add, cnt+1);

            while (window.get(add) > 1) {
                char remove = sources[start];
                start++;
                Integer value = window.get(remove);
                window.put(remove, value-1);
            }

            res = Math.max(res, end - start);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
