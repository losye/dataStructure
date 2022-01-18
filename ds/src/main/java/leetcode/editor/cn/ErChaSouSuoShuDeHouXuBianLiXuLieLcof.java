//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//
//
//
// 参考以下这颗二叉搜索树：
//
//      5
//    / \
//   2   6
//  / \
// 1   3
//
// 示例 1：
//
// 输入: [1,6,3,2,5]
//输出: false
//
// 示例 2：
//
// 输入: [1,3,2,6,5]
//输出: true
//
//
//
// 提示：
//
//
// 数组长度 <= 1000
//
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈
// 👍 411 👎 0


package leetcode.editor.cn;

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {

            return verify(postorder, 0, postorder.length - 1);
        }

        private boolean verify(int[] postorder, int lo, int hi) {
            if (lo >= hi) {
                return true;
            }

            int root = postorder[hi];

            int rightIndex = hi;
            for (int i = lo; i < hi; i++) {
                if (postorder[i] > root) {
                    rightIndex = i;
                    break;
                }
            }

            for(int i  = rightIndex; i < hi; i++){
                // 如果在右子树存在小于根节点的值，说明不符合条件
                if(postorder[i] < root){
                    return false;
                }
            }

            return verify(postorder, lo, rightIndex - 1) && verify(postorder, rightIndex, hi-1);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
