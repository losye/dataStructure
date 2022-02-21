//给定一组 互不相同 的单词， 找出所有 不同 的索引对 (i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["abcd","dcba","lls","s","sssll"]
//输出：[[0,1],[1,0],[3,2],[2,4]] 
//解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["bat","tab","cat"]
//输出：[[0,1],[1,0]] 
//解释：可拼接成的回文串为 ["battab","tabbat"] 
//
// 示例 3： 
//
// 
//输入：words = ["a",""]
//输出：[[0,1],[1,0]]
// 
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 5000 
// 0 <= words[i].length <= 300 
// words[i] 由小写英文字母组成 
// 
// Related Topics 字典树 数组 哈希表 字符串 
// 👍 295 👎 0


package leetcode.editor.cn;

public class PalindromePairs {
    public static void main(String[] args) {
        Solution solution = new PalindromePairs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}