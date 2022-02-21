//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母组成
//
// Related Topics 字符串 动态规划
// 👍 4727 👎 0


package leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }
        char[] chars = s.toCharArray();
        if (chars.length <= 0) {
            return "";
        }
        int len; int start = 0; int end = 0;
        for (int i = 0; i < chars.length; i++) {
            int len1 =  palindrome(chars, i, i);
            int len2 =  palindrome(chars, i, i + 1);
            len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

        // lo i hi
        //  babad
        private int palindrome(char[] chars, int lo, int hi) {
            while (lo >= 0 && hi < chars.length && chars[hi] == chars[lo]) {
                lo--; hi++;
            }
            return hi - lo -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
