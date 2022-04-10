//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
// Related Topics 字符串 动态规划 回溯
// 👍 2535 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<String> res = new LinkedList<>();

        //private String[] choices = new String[]{"(", ")"};

        public List<String> generateParenthesis(int n) {
            if (n == 0) {
                return res;
            }
            backTrack(new StringBuilder(), n, n);

            return res;
        }

        private void backTrack(StringBuilder path, int l, int r) {
            if (l > r) {
                return;
            }
            if (l < 0) {
                return;
            }

            if (l == 0 && r == 0) {
                res.add(path.toString());
                return;
            }

            path.append("(");
            backTrack(path, l - 1, r);
            path.deleteCharAt(path.length() - 1);

            path.append(")");
            backTrack(path, l, r - 1);
            path.deleteCharAt(path.length() - 1);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
