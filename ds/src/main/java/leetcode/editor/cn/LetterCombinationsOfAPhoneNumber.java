//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
// Related Topics 哈希表 字符串 回溯
// 👍 1835 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        String[] mapping = new String[]{
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        List<String> res = new LinkedList<>();

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.isEmpty()) {
                return res;
            }

            backTrack(digits, 0, new StringBuilder());

            return res;
        }

        private void backTrack(String digits, int index, StringBuilder path) {
            if (digits.length() == path.length()) {
                res.add(path.toString());
                return;
            }
            for (int i = index; i < digits.length(); i++) {
                int digit = digits.charAt(index) - '0';
                for (char c : mapping[digit].toCharArray()) {
                    path.append(c);

                    backTrack(digits, i + 1, path);

                    path.deleteCharAt(path.length() -1);
                }
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
