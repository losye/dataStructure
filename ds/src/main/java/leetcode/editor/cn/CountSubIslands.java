//给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。一个 岛屿 是由 四个方向 （水平或者竖
//直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。
//
// 如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那
//么我们称 grid2 中的这个岛屿为 子岛屿 。
//
// 请你返回 grid2 中 子岛屿 的 数目 。
//
//
//
// 示例 1：
//
// 输入：grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], gri
//d2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
//输出：3
//解释：如上图所示，左边为 grid1 ，右边为 grid2 。
//grid2 中标红的 1 区域是子岛屿，总共有 3 个子岛屿。
//
//
// 示例 2：
//
// 输入：grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], gri
//d2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
//输出：2
//解释：如上图所示，左边为 grid1 ，右边为 grid2 。
//grid2 中标红的 1 区域是子岛屿，总共有 2 个子岛屿。
//
//
//
//
// 提示：
//
//
// m == grid1.length == grid2.length
// n == grid1[i].length == grid2[i].length
// 1 <= m, n <= 500
// grid1[i][j] 和 grid2[i][j] 都要么是 0 要么是 1 。
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵
// 👍 37 👎 0


package leetcode.editor.cn;

public class CountSubIslands {
    public static void main(String[] args) {
        Solution solution = new CountSubIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int row = grid1.length;
            int col = grid1[0].length;

            int res = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid2[i][j] == 1 && dfs(grid1, grid2, i, j)) {
                        res++;
                    }
                }
            }
            return res;
        }

        private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
            int row = grid1.length;
            int col = grid1[0].length;

            if (i < 0 || i >= row || j < 0 || j >= col) {
                return true;
            }

            if (grid2[i][j] == 0) {
                return true;
            }

            grid2[i][j] = 0;

            boolean left = dfs(grid1, grid2, i - 1, j);
            boolean right = dfs(grid1, grid2, i + 1, j);
            boolean bottom = dfs(grid1, grid2, i, j - 1);
            boolean top = dfs(grid1, grid2, i, j + 1);

            // 注意如果dfs放在return 语句中的话, &&会进行短路运算,导致后面的dfs计算不到
            return grid1[i][j] == 1 && left && right && bottom && top;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
