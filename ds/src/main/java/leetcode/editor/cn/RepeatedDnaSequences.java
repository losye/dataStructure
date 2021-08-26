//所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复
//序列有时会对研究非常有帮助。
//
// 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
//
//
//
// 示例 1：
//
//
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
//
//
// 示例 2：
//
//
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 105
// s[i] 为 'A'、'C'、'G' 或 'T'
//
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希
// 👍 193 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDnaSequences {
    public static void main(String[] args) {
        Solution solution = new RepeatedDnaSequences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            if (s.length() < 10) {
                return new ArrayList<>();
            }
            HashSet<String> window = new HashSet<>();
            HashSet<String> seen = new HashSet<>();
            int L = 10;
            for (int i = 0; i < s.length() - L + 1; i++) {
                String substring = s.substring(i, i + L);
                if (!seen.add(substring)) {
                    window.add(substring);
                }
            }
            return new ArrayList<>(window);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
